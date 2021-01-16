package com.gi.builmanager.security.authentication.web;

import com.gi.builmanager.security.authentication.repositorio.projection.PermisoView;
import com.gi.builmanager.security.authentication.service.PermisoService;
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
