package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Unidad;
import com.gi.builmanager.dto.UnidadDto;
import com.gi.builmanager.repositorio.projection.UnidadView;
import com.gi.builmanager.service.UnidadService;
import com.gi.builmanager.util.BuilManagerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadController {
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private UnidadService unidadService;

    @GetMapping("/sin-asignacion/unidad-copropiedad")
    public List<UnidadDto> getUnidadesCopropiedadDisponiblesSinPropietario() {
        return BuilManagerUtils.convertList(
                unidadService.getUnidadesDisponiblesSinPropietario(true),
                Unidad.class,
                UnidadDto.class,
                conversionService
        );
    }

    @GetMapping("/sin-asignacion/")
    public List<UnidadDto> getUnidadesDisponiblesSinPropietario() {
        return BuilManagerUtils.convertList(
                unidadService.getUnidadesDisponiblesSinPropietario(false),
                Unidad.class,
                UnidadDto.class,
                conversionService
        );
    }

    @GetMapping("/disponibles")
    public List<UnidadDto> getUnidadesDisponiblesParaArriendo() {
        return BuilManagerUtils.convertList(
                unidadService.getUnidadesDisponiblesParaArriendo(),
                Unidad.class,
                UnidadDto.class,
                conversionService
        );
    }

}
