package com.gi.builmanager.infrastructure.hibernate.repository.projection;

public interface UsuarioView {

    int getIdUsuario();
    String getNombreUsuario();
    RolView getRol();
}
