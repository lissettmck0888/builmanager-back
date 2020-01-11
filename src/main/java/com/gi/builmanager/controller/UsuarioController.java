package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Usuario;
import com.gi.builmanager.dto.UsuarioDto;
import com.gi.builmanager.repositorio.projection.UsuarioView;
import com.gi.builmanager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = {"*"})
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<UsuarioView> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PostMapping("/")
    public Boolean crearUsuario(@RequestBody UsuarioDto usuarioDto){
        Usuario created = usuarioService.crearUsuario(usuarioDto);
        return created != null;
    }
}
