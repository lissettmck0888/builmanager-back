package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.Usuario;
import com.gi.builmanager.dto.UsuarioDto;
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
