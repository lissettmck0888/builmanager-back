package com.gi.builmanager.dominio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "asignacion")
@Entity
public class Asignacion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idAsignacion;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idpersona")
    private Persona persona;
    @Column
    private String tipoAsignacion;
    @Column
    private String estado;
    @Column
    private LocalDate fechaAsignacion;

    private Double totalMetrosCuadradosProrrateables;

    @OneToMany(mappedBy = "asignacion", cascade = CascadeType.ALL)
    private List<AsignacionUnidad> asignacionUnidads = new ArrayList<>();

    public List<AsignacionUnidad> getAsignacionUnidads() {
        return asignacionUnidads;
    }

    public void setAsignacionUnidads(List<AsignacionUnidad> asignacionUnidads) {
        this.asignacionUnidads = asignacionUnidads;
    }

    public Asignacion() {
    }

    public Asignacion(Integer idAsignacion, Persona persona,  String tipoAsignacion, String estado, LocalDate fechaAsignacion) {
        this.idAsignacion = idAsignacion;
        this.persona = persona;

        this.tipoAsignacion = tipoAsignacion;
        this.estado = estado;
        this.fechaAsignacion = fechaAsignacion;
    }

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

    public Double getTotalMetrosCuadradosProrrateables() {
        return totalMetrosCuadradosProrrateables;
    }

    public void setTotalMetrosCuadradosProrrateables(Double totalMetrosCuadradosProrrateables) {
        this.totalMetrosCuadradosProrrateables = totalMetrosCuadradosProrrateables;
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
}
