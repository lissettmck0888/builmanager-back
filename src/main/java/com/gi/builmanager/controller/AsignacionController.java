package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Asignacion;
import com.gi.builmanager.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignacion")
@CrossOrigin(origins = {"*"})
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Integer guardarAsignacion(@RequestBody Asignacion asignacion) {
        return asignacionService.save(asignacion) != null ? 1: 0;
    }

    @GetMapping("/all")
    public List<Asignacion> getAsignaciones() {
        return asignacionService.getAll();
    }
}
