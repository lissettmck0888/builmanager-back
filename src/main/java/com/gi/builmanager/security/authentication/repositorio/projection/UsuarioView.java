package com.gi.builmanager.security.authentication.repositorio.projection;

public interface UsuarioView {

    int getIdUsuario();
    String getNombreUsuario();
    RolView getRol();
}
