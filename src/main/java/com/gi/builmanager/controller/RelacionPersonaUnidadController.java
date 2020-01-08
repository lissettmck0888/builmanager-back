package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.RelacionPersonaUnidad;
import com.gi.builmanager.service.RelacionPersonaUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/personaunidades")
public class RelacionPersonaUnidadController {
    @Autowired
    private RelacionPersonaUnidadService relacionPersonaUnidadService;
    @GetMapping("/{idPersona}")
    public List<RelacionPersonaUnidad> getRelacionPersonaUnidad(@PathVariable int idPersona){
        return relacionPersonaUnidadService.getRelacionPersonaUnidad(idPersona);
    }
}
