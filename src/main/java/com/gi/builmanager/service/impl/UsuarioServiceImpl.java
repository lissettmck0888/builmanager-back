package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.Usuario;
import com.gi.builmanager.repositorio.UsuarioRepository;
import com.gi.builmanager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }
}
