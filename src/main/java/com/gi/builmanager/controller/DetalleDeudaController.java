package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.DetalleDeudadUnidad;
import com.gi.builmanager.dto.DetalleDeudaUnidadDto;
import com.gi.builmanager.repositorio.projection.DetalleDeudaUnidadView;
import com.gi.builmanager.service.DetalleDeudaUnidadService;
import com.gi.builmanager.util.BuilManagerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/deuda")
public class DetalleDeudaController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private DetalleDeudaUnidadService detalleDeudaUnidadService;

    @GetMapping(value = "/unidad/{idUnidad}")
    public List<DetalleDeudaUnidadView> getDetalleByUnidad(@PathVariable int idUnidad) {
        return detalleDeudaUnidadService.getByUnidad(idUnidad);
    }

    @GetMapping(value = "/periodo/{periodo}")
    public List<DetalleDeudaUnidadDto> getDetalleByPeriodo(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodo) {
        return BuilManagerUtils.convertList(
                detalleDeudaUnidadService.getByPeriodo(periodo),
                DetalleDeudadUnidad.class, DetalleDeudaUnidadDto.class, conversionService);
    }
}
