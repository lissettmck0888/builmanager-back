package com.gi.builmanager.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "rol")
@Entity
public class Rol {
    @Id @Column(name = "idrol")
    int idRol;
    @Column
    String nombre;


    public Rol() {
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
