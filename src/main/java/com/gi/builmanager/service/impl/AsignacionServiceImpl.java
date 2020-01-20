package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.Asignacion;
import com.gi.builmanager.repositorio.AsignacionRepository;
import com.gi.builmanager.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AsignacionServiceImpl implements AsignacionService {
    @Autowired
    private AsignacionRepository asignacionRepository;

    @Override
    public Asignacion save(Asignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }

    @Override
    public List<Asignacion> getAll() {
        return asignacionRepository.findAll();
    }

}
