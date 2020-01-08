package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.RelacionPersonaUnidad;
import com.gi.builmanager.repositorio.RelacionPersonaUnidadRepository;
import com.gi.builmanager.service.RelacionPersonaUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaUnidadServiceImpl implements RelacionPersonaUnidadService {
    @Autowired
    private RelacionPersonaUnidadRepository relacionPersonaUnidadRepository;
    @Override
    public List<RelacionPersonaUnidad> getRelacionPersonaUnidad(int idPersona) {
        return relacionPersonaUnidadRepository.findByPersona_IdPersona(idPersona);
    }
}
