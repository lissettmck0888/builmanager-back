package com.gi.builmanager.security.authentication.web;

import com.gi.builmanager.security.authentication.repository.entity.Usuario;
import com.gi.builmanager.security.authentication.dto.UsuarioDto;
import com.gi.builmanager.security.authentication.repository.projection.UsuarioView;
import com.gi.builmanager.security.authentication.service.UsuarioService;
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

    @DeleteMapping("/{idUsuario}")
    public  void eliminarUsuario(@PathVariable int idUsuario){
        usuarioService.eliminarUsuario(idUsuario);
    }
}
