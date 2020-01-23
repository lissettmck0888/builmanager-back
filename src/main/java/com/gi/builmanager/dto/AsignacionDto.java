package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.Persona;

import java.time.LocalDate;
import java.util.List;

public class AsignacionDto {

    private Integer idAsignacion;
    private Persona persona;
    private String tipoAsignacion;
    private String estado;
    private LocalDate fechaAsignacion;
    private List<AsignacionUnidadDto> asignacionUnidades;

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getTipoAsignacion() {
        return tipoAsignacion;
    }

    public void setTipoAsignacion(String tipoAsignacion) {
        this.tipoAsignacion = tipoAsignacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public List<AsignacionUnidadDto> getAsignacionUnidades() {
        return asignacionUnidades;
    }

    public void setAsignacionUnidades(List<AsignacionUnidadDto> asignacionUnidades) {
        this.asignacionUnidades = asignacionUnidades;
    }
}
