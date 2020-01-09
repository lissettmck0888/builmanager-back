package com.gi.builmanager.service;

import com.gi.builmanager.dominio.Permiso;

import java.util.List;

public interface PermisoService {
    List<Permiso> getPermiso(int idUsuario);
}
