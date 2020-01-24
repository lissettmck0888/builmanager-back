package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Abono;
import com.gi.builmanager.service.AbonosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/pagos")
public class AbonosController {
    @Autowired
    private AbonosServices abonosServices;

    @GetMapping(value = {"/idUnidad"})
    List<Abono>  listaAbonosPorUnidad(@PathVariable int idUnidad){
        return abonosServices.obtenerPagosPorUnidad(idUnidad);
    }
}
