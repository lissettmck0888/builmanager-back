package com.gi.builmanager.security.authentication.service;

import com.gi.builmanager.security.authentication.repository.entity.Usuario;
import com.gi.builmanager.security.authentication.dto.UsuarioDto;
import com.gi.builmanager.security.authentication.repository.projection.UsuarioView;

import java.util.List;

public interface UsuarioService {

    Usuario crearUsuario(UsuarioDto usuarioDto);
    List<UsuarioView> getUsuarios();
    void eliminarUsuario(int idUsuario);

}
