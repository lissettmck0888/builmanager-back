package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.Unidad;
import com.gi.builmanager.repositorio.UnidadRepository;
import com.gi.builmanager.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UnidadServiceImpl implements UnidadService {
    @Autowired
    private UnidadRepository unidadRepository;
    @Override
    public List<Unidad> getUnidadesDisponibles() {
        return unidadRepository.getUnidadesDisponibles();
    }
}
