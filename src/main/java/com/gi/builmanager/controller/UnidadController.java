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

    @GetMapping("/sin-asignacion")
    public List<Unidad> getUnidadesDisponiblesSinPropietario() {
        return unidadService.getUnidadesDisponiblesSinPropietario();
    }

    @GetMapping("/disponibles")
    public List<Unidad> getUnidadesDisponiblesParaArriendo() {
        return unidadService.getUnidadesDisponiblesParaArriendo();
    }
}
