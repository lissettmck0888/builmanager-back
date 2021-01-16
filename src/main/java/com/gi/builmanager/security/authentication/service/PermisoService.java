package com.gi.builmanager.security.authentication.service;

import com.gi.builmanager.security.authentication.repositorio.projection.PermisoView;

import java.util.List;

public interface PermisoService {
    List<PermisoView> getPermiso(int idUsuario);
    List<PermisoView> getPermisosRol(String nombre);
    List<PermisoView> getPermisos();
}
