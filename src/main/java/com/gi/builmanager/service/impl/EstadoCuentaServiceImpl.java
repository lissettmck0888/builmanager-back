package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.EstadoCuenta;
import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.repositorio.EstadoCuentaRepository;
import com.gi.builmanager.repositorio.GastoComunRepository;
import com.gi.builmanager.repositorio.projection.EstadoCuentaView;
import com.gi.builmanager.service.EstadoCuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EstadoCuentaServiceImpl implements EstadoCuentaService {

    @Autowired
    private EstadoCuentaRepository estadoCuentaRepository;
    @Autowired
    private GastoComunRepository gastoComunRepository;

    @Override
    public List<EstadoCuentaView> getByAsignacion(int ididAsignacion) {
        return estadoCuentaRepository.findByAsignacion_idAsignacion(ididAsignacion);
    }

    @Override
    public List<EstadoCuenta> getByPeriodo(LocalDate periodo) {
        GastoComun gastoComun = gastoComunRepository.findByPeriodo(periodo);
        return estadoCuentaRepository.findByGastoComun(gastoComun);
    }
}
