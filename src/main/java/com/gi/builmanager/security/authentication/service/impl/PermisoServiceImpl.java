package com.gi.builmanager.security.authentication.service.impl;

import com.gi.builmanager.security.authentication.repositorio.PermisoRepository;
import com.gi.builmanager.security.authentication.repositorio.projection.PermisoView;
import com.gi.builmanager.security.authentication.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermisoServiceImpl implements PermisoService {
    @Autowired
    private PermisoRepository permisoRepository;

    @Override
    public List<PermisoView> getPermiso(int idUsuario) {
        return null;
    }

    @Override
    public List<PermisoView> getPermisosRol(String nombre) {
        return permisoRepository.findByRoles_nombreIgnoreCase(nombre);
    }

    @Override
    public List<PermisoView> getPermisos() {
        return permisoRepository.findAllProjectedBy();
    }
}
