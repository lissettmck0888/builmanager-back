package com.gi.builmanager.dominio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "asignacion")
@Entity
public class Asignacion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idAsignacion;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idpersona")
    private Persona persona;
    @Column
    private String tipoAsignacion;
    @Column
    private String estado;
    @Column
    private LocalDate fechaAsignacion;
    @ManyToMany
    @JoinTable(
            name = "relacion_asignacion_unidad",
            joinColumns={@JoinColumn(name="idasignacion")},
            inverseJoinColumns={@JoinColumn(name="idunidad")})
    private List<Unidad> unidades;

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidad> unidades) {
        this.unidades = unidades;
    }

    public Asignacion() {
    }

    public Asignacion(int idAsignacion, Persona persona,  String tipoAsignacion, String estado, LocalDate fechaAsignacion) {
        this.idAsignacion = idAsignacion;
        this.persona = persona;

        this.tipoAsignacion = tipoAsignacion;
        this.estado = estado;
        this.fechaAsignacion = fechaAsignacion;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setIdPersona(Persona persona) {
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
}
