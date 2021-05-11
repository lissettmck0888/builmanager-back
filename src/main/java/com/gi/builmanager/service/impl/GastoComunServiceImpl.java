package com.gi.builmanager.service.impl;

import com.gi.builmanager.constants.EstadoGastoComunEnum;
import com.gi.builmanager.dominio.*;
import com.gi.builmanager.dto.EstadoCuentaDto;
import com.gi.builmanager.repositorio.*;
import com.gi.builmanager.service.GastoComunService;
import com.gi.builmanager.util.BuilManagerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private EstadoCuentaRepository estadoCuentaRepository;

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
    public List<EstadoCuentaDto> prorratearGastosPeriodo() {
        Optional<GastoComun> optionalGastoComunCerrado = gastoComunRepository.findUltimoGastoComunCerrado(EstadoGastoComunEnum.CLOSED.nombre);
        GastoComun gastoComunActual = gastoComunRepository.findByEstado(EstadoGastoComunEnum.CURRENT.nombre);

        Double totalM2Prorrateables = unidadRepository.totalMetrosCuadradosProrrateables();
        //Double totalM2ProrrateablesAsignados = unidadRepository.totalMetrosCuadradosProrrateablesAsignados();
        Double totalM2ProrrateablesNoAsignados = unidadRepository.totalMetrosCuadradosProrrateablesNoAsignados();

        //Asignacion asignacionCondominio = new Asignacion();//TODO crear fake asignacion para unidades sin propietario

        GastoComun gastoComunCerrado = optionalGastoComunCerrado.orElse(null);
        List<EstadoCuenta> estadosCuentaPeriodoAnterior = estadoCuentaRepository.findByGastoComun(gastoComunCerrado);
        List<Movimiento>  abonosPeriodoAnterior = movimientoRepository.findByGastoComunAndTipo(gastoComunCerrado, "Abono");

        List<EstadoCuentaDto> estadoCuentaDtoList = new ArrayList<>();
        List<Movimiento> movimientoList = new ArrayList<>();
        List<EstadoCuenta> estadoCuentaList = new ArrayList<>();

        asignacionRepository.findAll().forEach(asignacion -> {
            Double factorProrrateo = asignacion.getTotalMetrosCuadradosProrrateables() / totalM2Prorrateables;

            /*Optional<Unidad> opt = asignacion.getUnidades()
                    .stream().filter(Unidad::getEsUnidadCopropiedad).findFirst();

            Unidad unidad = null;
            if (opt.isPresent()) {
                unidad = opt.get();
            }*/

            Movimiento movimientoUnidad = Movimiento.builder()
                    .gastoComun(gastoComunActual)
                    .asignacion(asignacion)
                    .fecha(LocalDateTime.now())
                    .tipo("Cargo")
                    .monto(BuilManagerUtils.round(gastoComunActual.getMontoTotal() * factorProrrateo, 0))
            .build();
            movimientoList.add(movimientoUnidad);

            EstadoCuenta estadoCuenta = EstadoCuenta.builder()
                    .gastoComun(gastoComunActual)
                    .asignacion(asignacion)
                    .factorProrrateo(factorProrrateo)
                    .build();
            estadoCuentaList.add(estadoCuenta);

            this.calcularEstadoCuenta(estadoCuenta, movimientoUnidad, asignacion, estadosCuentaPeriodoAnterior, abonosPeriodoAnterior);
            estadoCuentaDtoList.add(EstadoCuentaDto.of(estadoCuenta));
        });

        movimientoRepository.saveAll(movimientoList);
        estadoCuentaRepository.saveAll(estadoCuentaList);

        return estadoCuentaDtoList;

    }

    private void calcularEstadoCuenta(EstadoCuenta estadoCuenta,
                                      Movimiento movimientoUnidad,
                                      Asignacion asignacion,
                                      List<EstadoCuenta> estadosCuentaPeriodoAnterior,
                                      List<Movimiento> abonosPeriodoAnterior) {

        Optional<Double> optionalEstadoCuenta =
                estadosCuentaPeriodoAnterior.stream()
                        .filter(estCta -> estCta.getAsignacion().equals(asignacion))
                        .map(EstadoCuenta::getSaldo).reduce(Double::sum);

        Optional<Double> optionalMovimientos =
                abonosPeriodoAnterior.stream()
                        .filter(movimiento -> movimiento.getAsignacion().equals(asignacion))
                        .map(Movimiento::getMonto).reduce(Double::sum);

        Double deuda = 0D;
        deuda += optionalEstadoCuenta.orElse(0D);
        deuda -= optionalMovimientos.orElse(0D);
        deuda += movimientoUnidad.getMonto();

        estadoCuenta.setMontoAnterior(optionalEstadoCuenta.orElse(0D) - optionalMovimientos.orElse(0D));
        estadoCuenta.setMontoInicial(movimientoUnidad.getMonto());
        estadoCuenta.setSaldo(deuda);

    }

    @Override
    public GastoComun cerrarGastoComun(GastoComun gastoComun) {

        GastoComun gastoComunActual = gastoComunRepository.findByEstado(EstadoGastoComunEnum.CURRENT.nombre);
        if(gastoComunActual != null){
            gastoComunActual.setEstado(EstadoGastoComunEnum.CLOSED.nombre);
            gastoComunRepository.save(gastoComunActual);
        }

        this.getPlantillaGastosOrdinarios().forEach(plantillaGastosOrdinarios -> {
            DetalleGastoComun detalleGastoComun = new DetalleGastoComun();
            detalleGastoComun.setItemGastoComun(plantillaGastosOrdinarios.getItemGastoComun());
            //detalleGastoComun.setGastoComun(gastoComun);
            detalleGastoComun.setMonto(plantillaGastosOrdinarios.getMonto());
            gastoComun.getListaDetalleGastoComun().add(detalleGastoComun);
        });

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
