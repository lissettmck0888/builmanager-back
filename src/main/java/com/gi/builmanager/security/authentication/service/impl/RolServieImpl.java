package com.gi.builmanager.security.authentication.service.impl;

import com.gi.builmanager.security.authentication.repository.entity.Rol;
import com.gi.builmanager.security.authentication.dto.RolDDto;
import com.gi.builmanager.security.authentication.repository.RolRepository;
import com.gi.builmanager.security.authentication.repository.projection.RolView;
import com.gi.builmanager.security.authentication.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolServieImpl implements RolService {
    @Autowired
    private ConversionService conversionService;
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

    @Override
    public Rol crearRol(RolDDto rolDto) {
        Rol rol = conversionService.convert(rolDto, Rol.class);
        return rolRepository.save(rol);
    }
}
