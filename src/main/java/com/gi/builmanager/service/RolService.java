package com.gi.builmanager.service;

import com.gi.builmanager.dominio.Rol;
import com.gi.builmanager.dto.RolDDto;
import com.gi.builmanager.repositorio.projection.RolView;

import java.util.List;

public interface RolService {
    List<Rol> getRol();
    List<RolView> getRolView();
    Rol crearRol(RolDDto rol);
}
