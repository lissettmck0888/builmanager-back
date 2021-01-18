package com.gi.builmanager.infrastructure.hibernate.repository.projection;

import com.gi.builmanager.infrastructure.hibernate.entity.Persona;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AsignacionView {

    Integer getIdAsignacion();
    Persona getPersona();
    String getTipoAsignacion();
    String getEstado();
    LocalDateTime getFechaAsignacion();
    Double getTotalMetrosCuadradosProrrateables();
    List<AsignacionUnidadView> getAsignacionUnidads();
}
