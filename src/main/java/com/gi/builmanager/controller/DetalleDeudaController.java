package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.EstadoCuenta;
import com.gi.builmanager.dto.EstadoCuentaDto;
import com.gi.builmanager.repositorio.projection.EstadoCuentaView;
import com.gi.builmanager.service.EstadoCuentaService;
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

    //@Autowired
    //private DetalleDeudaUnidadService detalleDeudaUnidadService;

    @Autowired
    private EstadoCuentaService estadoCuentaService;

    @GetMapping(value = "/unidad/{idUnidad}")
    //@PreAuthorize(value = "")
    //@PostAuthorize()
    public List<EstadoCuentaView> getDetalleByUnidad(@PathVariable int idUnidad) {
        return estadoCuentaService.getByUnidad(idUnidad);
    }

    @GetMapping(value = "/periodo/{periodo}")
    public List<EstadoCuentaDto> getDetalleByPeriodo(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodo) {
        return BuilManagerUtils.convertList(
                estadoCuentaService.getByPeriodo(periodo),
                EstadoCuenta.class, EstadoCuentaDto.class, conversionService);
    }
}
