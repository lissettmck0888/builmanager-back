package com.gi.builmanager.service;

import com.gi.builmanager.dominio.Usuario;
import com.gi.builmanager.dto.UsuarioDto;
import com.gi.builmanager.repositorio.projection.UsuarioView;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface UsuarioService {

    Usuario crearUsuario(UsuarioDto usuarioDto);
    List<UsuarioView> getUsuarios();
    void eliminarUsuario(int idUsuario);

}
