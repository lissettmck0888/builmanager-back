package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.Persona;
import com.gi.builmanager.repositorio.PersonaRepository;
import com.gi.builmanager.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getByFilter(String filter) {
        return personaRepository.findByFilter(filter);
    }

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona agregar(Persona persona) {
        return personaRepository.save(persona);
    }
}
