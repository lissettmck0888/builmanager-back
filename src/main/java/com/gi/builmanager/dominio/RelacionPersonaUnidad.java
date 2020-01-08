package com.gi.builmanager.dominio;

import javax.persistence.*;

@Table(name = "relacion_persona_unidad")
@Entity
public class RelacionPersonaUnidad {
    @Id @Column(name = "idrelacionperun")
    private  int idRelacionPersonaUnidad;
    @Column
    private String estado;
    @ManyToOne @JoinColumn(name = "idunidad")
    private Unidad unidad;
    @ManyToOne @JoinColumn(name = "idpersona")
    private Persona persona;

    public RelacionPersonaUnidad() {
    }

    public RelacionPersonaUnidad(int idRelacionPersonaUnidad, String estado, Unidad unidad, Persona persona) {
        this.idRelacionPersonaUnidad = idRelacionPersonaUnidad;
        this.estado = estado;
        this.unidad = unidad;
        this.persona = persona;
    }

    public int getIdRelacionPersonaUnidad() {
        return idRelacionPersonaUnidad;
    }

    public void setIdRelacionPersonaUnidad(int idRelacionPersonaUnidad) {
        this.idRelacionPersonaUnidad = idRelacionPersonaUnidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
