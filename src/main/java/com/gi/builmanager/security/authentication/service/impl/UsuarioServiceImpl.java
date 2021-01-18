package com.gi.builmanager.security.authentication.service.impl;

import com.gi.builmanager.security.authentication.repository.entity.Usuario;
import com.gi.builmanager.security.authentication.dto.UsuarioDto;
import com.gi.builmanager.security.authentication.repository.UsuarioRepository;
import com.gi.builmanager.security.authentication.repository.projection.UsuarioView;
import com.gi.builmanager.security.authentication.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioDto.getIdUsuario());
        if(optionalUsuario.isPresent()) {
            usuarioDto.setContrasena(optionalUsuario.get().getContrasena());
        }else {
            usuarioDto.setContrasena(passwordEncoder.encode(usuarioDto.getContrasena()));
        }
        return usuarioRepository.save(conversionService.convert(usuarioDto, Usuario.class));
    }

    @Override
    public List<UsuarioView> getUsuarios() {
        return usuarioRepository.findAllProjectedBy();
    }

    @Override
    public void eliminarUsuario(int idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
