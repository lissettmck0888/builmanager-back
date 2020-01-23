package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Asignacion;
import com.gi.builmanager.dto.AsignacionDto;
import com.gi.builmanager.repositorio.projection.AsignacionView;
import com.gi.builmanager.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignacion")
@CrossOrigin(origins = {"*"})
public class AsignacionController {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private AsignacionService asignacionService;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Integer guardarAsignacion(@RequestBody AsignacionDto asignacionDto) {
        return asignacionService.save(conversionService.convert(asignacionDto, Asignacion.class)) != null ? 1: 0;
    }

    @GetMapping("/all")
    public List<AsignacionView> getAsignaciones() {
        return asignacionService.getAll();
    }
}
