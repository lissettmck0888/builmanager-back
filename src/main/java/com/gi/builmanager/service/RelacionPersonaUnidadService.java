package com.gi.builmanager.service;

import com.gi.builmanager.dominio.RelacionPersonaUnidad;

import java.util.List;


public interface RelacionPersonaUnidadService {
    List<RelacionPersonaUnidad> getRelacionPersonaUnidad(int idPersona);
}
