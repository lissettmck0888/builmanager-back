package com.gi.builmanager.service.impl;

import com.gi.builmanager.constants.EstadoGastoComunEnum;
import com.gi.builmanager.dominio.*;
import com.gi.builmanager.dto.DetalleDeudaUnidadDto;
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
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

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
    public List<DetalleDeudaUnidadDto> prorratearGastosPeriodo() {
        Optional<GastoComun> optionalGastoComunCerrado = gastoComunRepository.findUltimoGastoComunCerrado();
        GastoComun gastoComunActual = gastoComunRepository.findByEstado(EstadoGastoComunEnum.CURRENT.nombre);

        Double totalM2Prorrateables = unidadRepository.totalMetrosCuadradosProrrateables();
        //Double totalM2ProrrateablesAsignados = unidadRepository.totalMetrosCuadradosProrrateablesAsignados();
        Double totalM2ProrrateablesNoAsignados = unidadRepository.totalMetrosCuadradosProrrateablesNoAsignados();

        //Asignacion asignacionCondominio = new Asignacion();//TODO crear fake asignacion para unidades sin propietario

        GastoComun gastoComunCerrado = optionalGastoComunCerrado.orElse(null);
        List<EstadoCuenta> estadosCuentaPeriodoAnterior = estadoCuentaRepository.findByGastoComun(gastoComunCerrado);
        List<Movimiento>  abonosPeriodoAnterior = movimientoRepository.findByGastoComunAndTipo(gastoComunCerrado, "Abono");

        List<DetalleDeudaUnidadDto> detalleDeudaUnidadDtoList = new ArrayList<>();
        List<Movimiento> movimientoList = new ArrayList<>();
        List<EstadoCuenta> estadoCuentaList = new ArrayList<>();


        List<Asignacion> asignacionList = asignacionRepository.findAll();
        asignacionList.forEach(asignacion -> {
            Double factorProrrateo = asignacion.getTotalMetrosCuadradosProrrateables() / totalM2Prorrateables;

            Optional<AsignacionUnidad> opt = asignacion.getAsignacionUnidads()
                    .stream().filter(AsignacionUnidad::getUnidadCopropiedad).findFirst();

            Unidad unidad = null;
            if (opt.isPresent()) {
                unidad = opt.get().getUnidad();
            }

            Movimiento movimientoUnidad = Movimiento.builder()
                    .gastoComun(gastoComunActual)
                    .unidad(unidad)
                    .fecha(LocalDateTime.now())
                    .tipo("Cargo")
                    .monto(BuilManagerUtils.round(gastoComunActual.getMontoTotal() * factorProrrateo, 0))
            .build();
            movimientoList.add(movimientoUnidad);

            EstadoCuenta estadoCuenta = EstadoCuenta.builder()
                    .gastoComun(gastoComunActual)
                    .unidad(unidad)
                    .factorProrrateo(factorProrrateo)
                    .build();
            estadoCuentaList.add(estadoCuenta);

            this.calcularEstadoCuenta(estadoCuenta, movimientoUnidad, unidad, estadosCuentaPeriodoAnterior, abonosPeriodoAnterior);
            detalleDeudaUnidadDtoList.add(DetalleDeudaUnidadDto.of(estadoCuenta));
        });

        movimientoRepository.saveAll(movimientoList);
        estadoCuentaRepository.saveAll(estadoCuentaList);

        return detalleDeudaUnidadDtoList;

    }

    private void calcularEstadoCuenta(EstadoCuenta estadoCuenta,
                                      Movimiento movimientoUnidad,
                                      Unidad unidad,
                                      List<EstadoCuenta> estadosCuentaPeriodoAnterior,
                                      List<Movimiento> abonosPeriodoAnterior) {

        Optional<Double> optionalEstadoCuenta =
                estadosCuentaPeriodoAnterior.stream()
                        .filter(estCta -> estCta.getUnidad().getIdUnidad().equals(unidad.getIdUnidad()))
                        .map(EstadoCuenta::getSaldo).reduce(Double::sum);

        Optional<Double> optionalMovimientos =
                abonosPeriodoAnterior.stream()
                        .filter(movimiento -> movimiento.getUnidad().getIdUnidad().equals(unidad.getIdUnidad()))
                        .map(Movimiento::getMonto).reduce(Double::sum);

        Double deuda = 0D;
        deuda += optionalEstadoCuenta.orElse(0D);
        deuda -= optionalMovimientos.orElse(0D);
        deuda += movimientoUnidad.getMonto();

        estadoCuenta.setMontoAnterior(optionalEstadoCuenta.orElse(0D) - optionalMovimientos.orElse(0D));
        estadoCuenta.setDeudaInicial(movimientoUnidad.getMonto());
        estadoCuenta.setSaldo(deuda);

    }

    @Override
    public GastoComun cerrarGastoComun() {

        /*
           obtener gasto comun abierto. Asignar los gastos ordinarios al gasto comun
         */
        GastoComun gcAbierto = gastoComunRepository.findByEstado("Abierto");
        List<PlantillaGastosOrdinarios> gastosOrdinariosList =
                plantillaGastosOrdinariosRepository.findByActivoEqualsTrue();
        gastosOrdinariosList.forEach(gasto -> {
            DetalleGastoComun detalleGastoComun = new DetalleGastoComun();
            detalleGastoComun.setGastoComun(gcAbierto);
            detalleGastoComun.setMonto(gasto.getMonto());
            detalleGastoComun.setItemGastoComun(gasto.getItemGastoComun());
            gcAbierto.getListaDetalleGastoComun().add(detalleGastoComun);
        });

        GastoComun gcActual = gastoComunRepository.findByEstado(EstadoGastoComunEnum.CURRENT.nombre);

        if(gcActual != null){
            gcActual.setEstado(EstadoGastoComunEnum.CLOSED.nombre);
            gastoComunRepository.save(gcActual);
        }

        Double total = gcAbierto.getListaDetalleGastoComun()
                .stream()
                .map(DetalleGastoComun::getMonto)
                .reduce(0D, Double::sum);
        gcAbierto.setMontoTotal(total);
        gcAbierto.setEstado(EstadoGastoComunEnum.CURRENT.nombre);

        GastoComun nuevoGastoComun = new GastoComun();
        nuevoGastoComun.setEstado(EstadoGastoComunEnum.OPENED.nombre);
        nuevoGastoComun.setPeriodo(gcAbierto.getPeriodo().plusMonths(1));
        gastoComunRepository.save(nuevoGastoComun);
        return gastoComunRepository.save(gcAbierto);
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
