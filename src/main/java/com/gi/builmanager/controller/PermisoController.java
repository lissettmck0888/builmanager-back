package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Permiso;
import com.gi.builmanager.repositorio.projection.PermisoView;
import com.gi.builmanager.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/permisos")
public class PermisoController {
    @Autowired
    private PermisoService permisoService;

    /*@GetMapping("/{idUsuario}")
    public List<Permiso> getPermiso(@PathVariable int idUsuario){
        return permisoService.getPermiso(idUsuario);
    }
*/
    @GetMapping("/rol/{idRol}")
    public List<PermisoView> getPermisosRol(@PathVariable int idRol){
        return permisoService.getPermisosRol(idRol);
    }

}
