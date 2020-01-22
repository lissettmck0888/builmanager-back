package com.gi.builmanager.dominio;

import javax.persistence.*;

@Table(name = "item_gasto_comun")
@Entity
public class ItemGastoComun {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iditemgastocomun")
    private Integer idItemGastoComun;
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

    public Integer getIdItemGastoComun() {
        return idItemGastoComun;
    }

    public void setIdItemGastoComun(Integer idItemGastoComun) {
        this.idItemGastoComun = idItemGastoComun;
    }
}
