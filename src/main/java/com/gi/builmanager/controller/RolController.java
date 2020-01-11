package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Rol;
import com.gi.builmanager.dto.RolDDto;
import com.gi.builmanager.repositorio.projection.RolView;
import com.gi.builmanager.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = {"*"})
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping("/")
    public List<RolView> getRolView(){
        return rolService.getRolView();

    }
    @PostMapping("/")
    public Boolean guardarRolDto(@RequestBody RolDDto rol){
        rolService.crearRol(rol);
        return true;
    }
}
