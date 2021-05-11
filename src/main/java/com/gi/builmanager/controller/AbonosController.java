
package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Movimiento;
import com.gi.builmanager.dto.MovimientoDto;
import com.gi.builmanager.service.AbonosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/abono")
public class AbonosController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private AbonosServices abonosServices;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public MovimientoDto registrarAbono(@RequestBody MovimientoDto movimientoDto) {
        Movimiento movimiento = abonosServices.registrarAbono(
                movimientoDto.getMonto(),movimientoDto.getIdAsignacion(),movimientoDto.getIdGastoComun());
        return conversionService.convert(movimiento, MovimientoDto.class);
    }

    /*@GetMapping(value = "/unidad/{idUnidad}")
    public List<Movimiento>  listaAbonosPorUnidad(@PathVariable int idUnidad){
        return BuilManagerUtils.convertList(abonosServices.obtenerPagosPorUnidad(idUnidad),
                Abono.class, AbonoDto.class, conversionService);
    }

    @GetMapping(value = "/periodo/{periodo}")
    public List<Movimiento>  listaAbonosPorPeriodo(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodo){
        return BuilManagerUtils.convertList(abonosServices.obtenerPagosPorPeriodo(periodo),
                Abono.class, AbonoDto.class, conversionService);
    }*/


}

