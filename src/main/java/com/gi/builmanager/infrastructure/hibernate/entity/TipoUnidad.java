package com.gi.builmanager.infrastructure.hibernate.entity;

import javax.persistence.*;

@Table(name = "tipo_unidad")
@Entity
public class TipoUnidad {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipounidad")
    private Integer idTipoUnidad;
    @Column
    private String nombre;

    public TipoUnidad() {
    }

    public TipoUnidad(Integer idTipoUnidad, String nombre) {
        this.idTipoUnidad = idTipoUnidad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTipoUnidad() {
        return idTipoUnidad;
    }

    public void setIdTipoUnidad(Integer idTipoUnidad) {
        this.idTipoUnidad = idTipoUnidad;
    }
}
