package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Permiso;
import com.gi.builmanager.repositorio.projection.PermisoView;
import com.gi.builmanager.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/permisos")
@CrossOrigin(origins = {"*"})
public class PermisoController {
    @Autowired
    private PermisoService permisoService;

    /*@GetMapping("/{idUsuario}")
    public List<Permiso> getPermiso(@PathVariable int idUsuario){
        return permisoService.getPermiso(idUsuario);
    }
*/
    @GetMapping("/rol/{nombreRol}")
    public List<PermisoView> getPermisosRol(@PathVariable String nombreRol){
        return permisoService.getPermisosRol(nombreRol);
    }

    @GetMapping("/")
    public List<PermisoView> getPermisos(){
        return permisoService.getPermisos();
    }
}
