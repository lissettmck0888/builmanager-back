package com.gi.builmanager.dto;

public class ItemGastoComunDto {
    private int idItemGastoComun;
    private  String nombre;
    private  String descripcion;

    public int getIdItemGastoComun() {
        return idItemGastoComun;
    }

    public void setIdItemGastoComun(int idItemGastoComun) {
        this.idItemGastoComun = idItemGastoComun;
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
}
