package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Unidad;
import com.gi.builmanager.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/unidades")
public class UnidadController {
    @Autowired
    private UnidadService unidadService;
    @GetMapping("/")
    public List<Unidad> getUnidad(){
        return unidadService.getUnidad();
    }
}
