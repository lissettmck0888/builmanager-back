package com.gi.builmanager.dto;

public class UsuarioDto {

    private int idUsuario;
    private String nombreUsuario;
    private String contrasena;
    private RolDDto rol;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public RolDDto getRol() {
        return rol;
    }

    public void setRol(RolDDto rol) {
        this.rol = rol;
    }
}
