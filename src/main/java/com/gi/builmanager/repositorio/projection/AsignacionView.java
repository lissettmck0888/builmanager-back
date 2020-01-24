package com.gi.builmanager.repositorio.projection;

import com.gi.builmanager.dominio.Persona;

import java.time.LocalDate;
import java.util.List;

public interface AsignacionView {

    Integer getIdAsignacion();
    Persona getPersona();
    String getTipoAsignacion();
    String getEstado();
    LocalDate getFechaAsignacion();
    Double getTotalMetrosCuadradosProrrateables();
    List<AsignacionUnidadView> getAsignacionUnidads();
}
