package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.Abono;
import com.gi.builmanager.repositorio.AbonosRepository;
import com.gi.builmanager.service.AbonosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AbonosServicesImpl implements AbonosServices {

    @Autowired
    private AbonosRepository abonosRepository;

    @Override
    public Abono registrarPagos(Abono abono) {
        return abonosRepository.save(abono);
    }

    @Override
    public List<Abono> obtenerPagosPorUnidad(Integer idUnidad) {
        return abonosRepository.findAllByDetalleDeudadUnidad_unidad_IdUnidad(idUnidad);
    }

    @Override
    public List<Abono> obtenerPagosPorPeriodo(LocalDate periodo) {
        return abonosRepository.findAllByDetalleDeudadUnidad_gastoComun_periodo(periodo);
    }

}
