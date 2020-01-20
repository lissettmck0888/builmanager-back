package com.gi.builmanager.service;

import com.gi.builmanager.dominio.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> getByFilter(String filter);
    List<Persona> getAll();
    Persona agregar(Persona persona);
}
