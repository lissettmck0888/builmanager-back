package com.gi.builmanager.service;

import com.gi.builmanager.dominio.Usuario;
import com.gi.builmanager.repositorio.projection.UsuarioView;

import java.util.List;

public interface UsuarioService {

    List<UsuarioView> getUsuarios();


}
