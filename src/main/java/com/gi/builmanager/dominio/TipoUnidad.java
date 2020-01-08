package com.gi.builmanager.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tipo_unidad")
@Entity
public class TipoUnidad {
    @Id @Column(name = "idtipounidad")
    private int idTipoUnidad;
    @Column
    private String nombre;

    public TipoUnidad() {
    }

    public TipoUnidad(int idTipoUnidad, String nombre) {
        this.idTipoUnidad = idTipoUnidad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipoUnidad() {
        return idTipoUnidad;
    }

    public void setIdTipoUnidad(int idTipoUnidad) {
        this.idTipoUnidad = idTipoUnidad;
    }
}
