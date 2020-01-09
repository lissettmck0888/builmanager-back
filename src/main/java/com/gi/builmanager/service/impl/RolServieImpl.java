package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.Rol;
import com.gi.builmanager.repositorio.RolRepository;
import com.gi.builmanager.repositorio.projection.RolView;
import com.gi.builmanager.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolServieImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> getRol() {
        return rolRepository.findAll();
    }

    @Override
    public List<RolView> getRolView() {
        return rolRepository.findAllProjectedBy();
    }
}
