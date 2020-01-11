package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.Permiso;

import java.util.List;

public class RolDDto {
    private int idRol;
    private String nombre;
    private List<PermisoDto> permisos;


    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PermisoDto> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<PermisoDto> listaPermisos) {
        this.permisos = listaPermisos;
    }
}
