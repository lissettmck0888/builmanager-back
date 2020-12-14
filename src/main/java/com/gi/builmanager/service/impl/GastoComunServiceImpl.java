package com.gi.builmanager.service.impl;

import com.gi.builmanager.constants.EstadoGastoComunEnum;
import com.gi.builmanager.dominio.*;
import com.gi.builmanager.repositorio.*;
import com.gi.builmanager.service.GastoComunService;
import com.gi.builmanager.util.BuilManagerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class GastoComunServiceImpl implements GastoComunService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GastoComunServiceImpl.class);

    private final DecimalFormat factorProrrateoFormat = new DecimalFormat("#.#####");
    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Autowired
    private ItemGastoComunRepository itemGastoComunRepository;
    @Autowired
    private PlantillaGastosOrdinariosRepository plantillaGastosOrdinariosRepository;
    @Autowired
    private UnidadRepository unidadRepository;
    @Autowired
    private AsignacionRepository asignacionRepository;
    @Autowired
    private MovimientoRepository movimientoRepository ;

    @Override
    public GastoComun actualizar(GastoComun gastoComun) {
        gastoComun.getListaDetalleGastoComun().stream().forEach(detalleGastoComun -> {
            if(detalleGastoComun.getItemGastoComun().getIdItemGastoComun() == null ||
                    detalleGastoComun.getItemGastoComun().getIdItemGastoComun() == 0){
                ItemGastoComun item = itemGastoComunRepository.save(detalleGastoComun.getItemGastoComun());
                detalleGastoComun.setItemGastoComun(item);
            }
        });
        return gastoComunRepository.save(gastoComun);
    }

    @Override
    public GastoComun getGastoComunAbierto() {
        return gastoComunRepository.findByEstado(EstadoGastoComunEnum.OPENED.nombre);
    }

    @Override
    public List<GastoComun> getGastoComun() {
        return gastoComunRepository.findAll();
    }

    @Override
    public List<Movimiento> prorratearGastosPeriodo() {
        GastoComun gastoComunActual = gastoComunRepository.findByEstado(EstadoGastoComunEnum.CURRENT.nombre);

        Double totalM2Prorrateables = unidadRepository.totalMetrosCuadradosProrrateables();
        //Double totalM2ProrrateablesAsignados = unidadRepository.totalMetrosCuadradosProrrateablesAsignados();
        Double totalM2ProrrateablesNoAsignados = unidadRepository.totalMetrosCuadradosProrrateablesNoAsignados();

        //Asignacion asignacionCondominio = new Asignacion();//TODO crear fake asignacion para unidades sin propietario

        List<Movimiento> movimientoList = new ArrayList<>();
        List<Asignacion> asignaciones = asignacionRepository.findAll();
        asignaciones.stream().forEach(asignacion -> {
            Double factorProrrateo = asignacion.getTotalMetrosCuadradosProrrateables() / totalM2Prorrateables;

            Movimiento movimientoUnidad = new Movimiento();
            /*movimientoUnidad.setResponsable(
                    String.format("%s %s %s",
                            asignacion.getPersona().getNombres(),
                            asignacion.getPersona().getApellidoPaterno(),
                            asignacion.getPersona().getApellidoMaterno())
            );*/
            movimientoUnidad.setGastoComun(gastoComunActual);
            Optional<AsignacionUnidad> opt = asignacion.getAsignacionUnidads()
                    .stream().filter(AsignacionUnidad::getUnidadCopropiedad).findFirst();

            opt.ifPresent(asignacionUnidad -> movimientoUnidad.setUnidad(asignacionUnidad.getUnidad()));

            //detalleDeudadUnidad.setFactorProrrateo(factorProrrateo);
            movimientoUnidad.setMonto(BuilManagerUtils.round(gastoComunActual.getMontoTotal() * factorProrrateo, 0));
            //detalleDeudadUnidad.setTotal(detalleDeudadUnidad.getMonto());
            //detalleDeudadUnidad.setEstado("Pendiente");
            movimientoList.add(movimientoRepository.save(movimientoUnidad));
        });

        //sumarDeudaPeriodoAnterior(detalleDeudadUnidadList, gastoComunActual.getPeriodo().minusMonths(1));

        return movimientoList;

    }

    /*private void sumarDeudaPeriodoAnterior(List<DetalleDeudadUnidad> periodoActual, LocalDate periodoAnterior) {
        GastoComun gastoComunAnterior =
                gastoComunRepository.findByEstadoAndPeriodo(EstadoGastoComunEnum.CLOSED.nombre, periodoAnterior);
        if(gastoComunAnterior != null) {
            List<DetalleDeudadUnidad> detalleDeudaAnterior =
                    detalleDeudaUnidadRepository.findByGastoComun_Periodo(gastoComunAnterior.getPeriodo());
            periodoActual.forEach(detalle -> {
                Optional<DetalleDeudadUnidad> opt = detalleDeudaAnterior.stream().filter(detalleAnterior ->
                        detalleAnterior.getUnidad().getIdUnidad() == detalle.getUnidad().getIdUnidad()).findFirst();
                if(opt.isPresent()){
                    detalle.setMontoAnterior(opt.get().getTotal());
                    detalle.setTotal(detalle.getTotal() + detalle.getMontoAnterior());
                }
            });
            detalleDeudaUnidadRepository.saveAll(periodoActual);
        }
    }*/

    @Override
    public GastoComun cerrarGastoComun(GastoComun gastoComun) {

        GastoComun gastoComunActual = gastoComunRepository.findByEstado(EstadoGastoComunEnum.CURRENT.nombre);
        if(gastoComunActual != null){
            gastoComunActual.setEstado(EstadoGastoComunEnum.CLOSED.nombre);
            gastoComunRepository.save(gastoComunActual);
        }

        Double total = gastoComun.getListaDetalleGastoComun()
                .stream()
                .map(DetalleGastoComun::getMonto)
                .reduce(0D, Double::sum);
        gastoComun.setMontoTotal(total);
        gastoComun.setEstado(EstadoGastoComunEnum.CURRENT.nombre);

        GastoComun nuevoGastoComun = new GastoComun();
        nuevoGastoComun.setEstado(EstadoGastoComunEnum.OPENED.nombre);
        nuevoGastoComun.setPeriodo(gastoComun.getPeriodo().plusMonths(1));
        gastoComunRepository.save(nuevoGastoComun);
        return gastoComunRepository.save(gastoComun);
    }

    @Override
    public ItemGastoComun guardarItem(ItemGastoComun itemGastoComun) {
        return itemGastoComunRepository.save(itemGastoComun);
    }

    @Override
    public List<ItemGastoComun> getItems(String tipo) {
        return itemGastoComunRepository.findAllByTipo(tipo);
    }

    @Override
    public List<PlantillaGastosOrdinarios> getPlantillaGastosOrdinarios() {
        return plantillaGastosOrdinariosRepository.findByActivoEqualsTrue();
    }

    @Override
    public LocalDate getPeriodoActual() {
        GastoComun gastoComun = gastoComunRepository.findByEstado(EstadoGastoComunEnum.CURRENT.nombre);
        return gastoComun != null ? gastoComun.getPeriodo() : null;
    }


}
