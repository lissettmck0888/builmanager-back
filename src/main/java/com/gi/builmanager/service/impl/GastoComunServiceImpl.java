package com.gi.builmanager.service.impl;

import com.gi.builmanager.constants.EstadoGastoComunEnum;
import com.gi.builmanager.dominio.*;
import com.gi.builmanager.repositorio.*;
import com.gi.builmanager.repositorio.projection.AsignacionView;
import com.gi.builmanager.repositorio.projection.GastoComunView;
import com.gi.builmanager.service.GastoComunService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GastoComunServiceImpl implements GastoComunService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GastoComunServiceImpl.class);

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
    private DetalleDeudaUnidadRepository detalleDeudaUnidadRepository;

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
    public List<DetalleDeudadUnidad> prorratearGastosPeriodo() {
        GastoComun gastoComunActual = gastoComunRepository.findByEstado(EstadoGastoComunEnum.CURRENT.nombre); // cerrarGastoComun();
        Double totalM2Prorrateables = unidadRepository.totalMetrosCuadradosProrrateables();
        //Double totalM2ProrrateablesAsignados = unidadRepository.totalMetrosCuadradosProrrateablesAsignados();
        Double totalM2ProrrateablesNoAsignados = unidadRepository.totalMetrosCuadradosProrrateablesNoAsignados();

        Asignacion asignacionCondominio = new Asignacion();//TODO crear fake asignacion para unidades sin propietario
        Map<Asignacion, Double> factorProrrateoMap = new HashMap<>();
        factorProrrateoMap.put(asignacionCondominio, totalM2ProrrateablesNoAsignados / totalM2Prorrateables);

        List<DetalleDeudadUnidad> detalleDeudadUnidadList = new ArrayList<>();
        List<Asignacion> asignaciones = asignacionRepository.findAll();
        asignaciones.stream().forEach(asignacionView -> {
            Double factorProrrateo = asignacionView.getTotalMetrosCuadradosProrrateables() / totalM2Prorrateables;
            factorProrrateoMap.put(asignacionView, factorProrrateo) ;

            DetalleDeudadUnidad detalleDeudadUnidad = new DetalleDeudadUnidad();
            detalleDeudadUnidad.setGastoComun(gastoComunActual);
            Optional<AsignacionUnidad> opt = asignacionView.getAsignacionUnidads()
                    .stream().filter(asignacionUnidad -> asignacionUnidad.getUnidadCopropiedad()).findFirst();
            if(opt.isPresent()){
                detalleDeudadUnidad.setUnidad(opt.get().getUnidad());
            }
            detalleDeudadUnidad.setFactorProrrateo(factorProrrateo);
            detalleDeudadUnidad.setMonto(gastoComunActual.getMontoTotal() * factorProrrateo);
            detalleDeudadUnidad.setEstado("Pendiente");
            detalleDeudadUnidadList.add(detalleDeudaUnidadRepository.save(detalleDeudadUnidad));
        });

        gastoComunActual.setEstado(EstadoGastoComunEnum.CLOSED.nombre);
        gastoComunRepository.save(gastoComunActual);
        //todo borrar, solo para verificar factor prorrateo
        /*Double unidadFactor = 0D;
        for(Double factor: factorProrrateoMap.values()){
            unidadFactor += factor;
        }*/

        return detalleDeudadUnidadList;
    }

    @Override
    public GastoComun cerrarGastoComun(GastoComun gastoComun) {
        //GastoComun gastoComun = gastoComunRepository.findByEstado(EstadoGastoComunEnum.OPENED.nombre);
        Double total = gastoComun.getListaDetalleGastoComun()
                .stream()
                .map(detalleGastoComun -> detalleGastoComun.getMonto())
                .reduce(0D, (subtotal,element)->subtotal + element);
        gastoComun.setMontoTotal(total);
        gastoComun.setEstado(EstadoGastoComunEnum.CURRENT.nombre);
        return gastoComunRepository.save(gastoComun);
    }

    @Override
    public ItemGastoComun guardarItem(ItemGastoComun itemGastoComun) {
        return itemGastoComunRepository.save(itemGastoComun);
    }

    @Override
    public List<ItemGastoComun> getItems() {
        return itemGastoComunRepository.findAll();
    }

    @Override
    public List<PlantillaGastosOrdinarios> getPlantillaGastosOrdinarios() {
        return plantillaGastosOrdinariosRepository.findByActivoEqualsTrue();
    }


}
