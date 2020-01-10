package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.Permiso;
import com.gi.builmanager.repositorio.PermisoRepository;
import com.gi.builmanager.repositorio.projection.PermisoView;
import com.gi.builmanager.service.PermisoService;
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
    public List<PermisoView> getPermisosRol(int idRol) {
        return permisoRepository.findByRoles_idRol(idRol);
    }

    @Override
    public List<PermisoView> getPermisos() {
        return permisoRepository.findAllProjectedBy();
    }
}
