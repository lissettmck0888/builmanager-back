package com.gi.builmanager.security.authentication.repository.projection;

public interface UsuarioView {

    int getIdUsuario();
    String getNombreUsuario();
    RolView getRol();
}
