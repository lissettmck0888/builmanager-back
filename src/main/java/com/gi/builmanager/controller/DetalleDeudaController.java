package com.gi.builmanager.controller;

import com.gi.builmanager.repositorio.projection.DetalleDeudaUnidadView;
import com.gi.builmanager.service.DetalleDeudaUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/deuda")
public class DetalleDeudaController {

    @Autowired
    private DetalleDeudaUnidadService detalleDeudaUnidadService;

    @GetMapping(value = "/{idUnidad}")
    public List<DetalleDeudaUnidadView> getDetalleByUnidad(@PathVariable int idUnidad) {
        return detalleDeudaUnidadService.getByUnidad(idUnidad);
    }
}
