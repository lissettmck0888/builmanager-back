package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Rol;
import com.gi.builmanager.repositorio.projection.RolView;
import com.gi.builmanager.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping("/rol")
    public List<Rol> getRol(){
        return rolService.getRol();
    }

    @GetMapping("/")
    public List<RolView> getRolView(){
        return rolService.getRolView();
    }
}
