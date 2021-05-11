package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.EstadoCuenta;
import com.gi.builmanager.dominio.Movimiento;
import com.gi.builmanager.repositorio.*;
import com.gi.builmanager.service.AbonosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AbonosServicesImpl implements AbonosServices {

    @Autowired
    private UnidadRepository unidadRepository;
    @Autowired
    private AsignacionRepository asignacionRepository;
    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private EstadoCuentaRepository estadoCuentaRepository;

    @Override
    public Movimiento registrarAbono(Double monto, Integer idUnidad, Integer idGastoComun) {
        Movimiento abono = Movimiento.builder()
                .gastoComun(gastoComunRepository.findById(idGastoComun).orElseThrow(IllegalArgumentException::new))
                .asignacion(asignacionRepository.findById(idUnidad).orElseThrow(IllegalArgumentException::new))
                .fecha(LocalDateTime.now())
                .monto(monto)
                .tipo("Abono")
                .build();
        Movimiento movimientoGuardado =  movimientoRepository.save(abono);
        actualizarEstadoCuenta(movimientoGuardado);
        return movimientoGuardado;
    }

    private void actualizarEstadoCuenta(Movimiento movimiento){
        EstadoCuenta estadoCuenta = estadoCuentaRepository.findByGastoComunAndAsignacion(movimiento.getGastoComun(), movimiento.getAsignacion());
        Double abonoTemporal = estadoCuenta.getAbonos() != null ? estadoCuenta.getAbonos() : 0;
        estadoCuenta.setAbonos(abonoTemporal + movimiento.getMonto());
        estadoCuenta.setSaldo(estadoCuenta.getMontoInicial() + estadoCuenta.getMontoAnterior() - estadoCuenta.getAbonos());
        estadoCuentaRepository.save(estadoCuenta);
    }

    /*@Override
    public List<Movimiento> obtenerPagosPorUnidad(Integer idUnidad) {
        return null;
    }

    @Override
    public List<Movimiento> obtenerPagosPorPeriodo(LocalDate periodo) {
        return null;
    }*/

}
