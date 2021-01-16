package com.gi.builmanager.security.authentication.service;

import com.gi.builmanager.security.authentication.repositorio.dominio.Rol;
import com.gi.builmanager.security.authentication.dto.RolDDto;
import com.gi.builmanager.security.authentication.repositorio.projection.RolView;

import java.util.List;

public interface RolService {
    List<Rol> getRol();
    List<RolView> getRolView();
    Rol crearRol(RolDDto rol);
}
