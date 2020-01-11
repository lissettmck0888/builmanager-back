package com.gi.builmanager.service;

import com.gi.builmanager.dominio.Permiso;
import com.gi.builmanager.repositorio.projection.PermisoView;

import java.util.List;

public interface PermisoService {
    List<PermisoView> getPermiso(int idUsuario);
    List<PermisoView> getPermisosRol(String nombre);
    List<PermisoView> getPermisos();
}
