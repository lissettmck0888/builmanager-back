package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.Usuario;
import com.gi.builmanager.dto.UsuarioDto;
import com.gi.builmanager.repositorio.UsuarioRepository;
import com.gi.builmanager.repositorio.projection.UsuarioView;
import com.gi.builmanager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario crearUsuario(UsuarioDto usuarioDto) {
        usuarioDto.setContrasena(passwordEncoder.encode(usuarioDto.getContrasena()));
        return usuarioRepository.save(conversionService.convert(usuarioDto, Usuario.class));
    }

    @Override
    public List<UsuarioView> getUsuarios() {
        return usuarioRepository.findAllProjectedBy();
    }
}
