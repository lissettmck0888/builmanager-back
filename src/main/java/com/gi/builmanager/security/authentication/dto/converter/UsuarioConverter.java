package com.gi.builmanager.security.authentication.dto.converter;

import com.gi.builmanager.security.authentication.repository.entity.Usuario;
import com.gi.builmanager.security.authentication.dto.UsuarioDto;
import org.springframework.core.convert.converter.Converter;

public class UsuarioConverter implements Converter<UsuarioDto, Usuario> {

    private RolConverter rolConverter = new RolConverter();

    @Override
    public Usuario convert(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDto.getIdUsuario());
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuario.setContrasena(usuarioDto.getContrasena());
        usuario.setRol(rolConverter.convert(usuarioDto.getRol()));
        return usuario;
    }
}
