package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.Persona;
import com.gi.builmanager.repositorio.PersonaRepository;
import com.gi.builmanager.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        return personaRepository.findAllActive();
    }

    @Override
    public Persona agregar(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public boolean eliminar(Integer id) {
         Persona persona = personaRepository.findById(id).orElse(null);
         if(Objects.nonNull(persona)){
             persona.setEstado(false);
             personaRepository.save(persona);
             return true;
         }
         return false;
    }
}
