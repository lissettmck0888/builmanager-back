package com.gi.builmanager.service;

import com.gi.builmanager.dominio.Asignacion;

import java.util.List;

public interface AsignacionService {
   // List<Asignacion> getAsignacion(int idAsignacion);

    Asignacion save(Asignacion asignacion);
    List<Asignacion> getAll();
}
