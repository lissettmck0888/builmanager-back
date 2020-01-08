package com.gi.builmanager.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "item_gasto_comun")
@Entity
public class ItemGastoComun {
    @Id @Column(name = "iditemgastocomun")
    private int idItemGastoComun;
    @Column
    private String nombre;
    @Column
    private String descripcion;

    public ItemGastoComun() {
    }

    public ItemGastoComun(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdItemGastoComun() {
        return idItemGastoComun;
    }

    public void setIdItemGastoComun(int idItemGastoComun) {
        this.idItemGastoComun = idItemGastoComun;
    }
}
