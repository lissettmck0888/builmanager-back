package com.gi.builmanager.interfaces.web;/*
package com.gi.builmanager.interfaces.web;

import com.gi.builmanager.security.authentication.repositorio.dominio.Abono;
import com.gi.builmanager.security.authentication.dto.AbonoDto;
import com.gi.builmanager.security.authentication.service.AbonosServices;
import com.gi.builmanager.util.BuilManagerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value ="/abono/")
public class AbonosController {

    @Autowired
    private ConversionService conversionService;

    //@Autowired
    private AbonosServices abonosServices;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AbonoDto registrarAbono(AbonoDto abonoDto) {
        Abono abono = abonosServices.registrarPagos(conversionService.convert(abonoDto, Abono.class));
        return conversionService.convert(abono, AbonoDto.class);
    }

    @GetMapping(value = "/unidad/{idUnidad}")
    public List<AbonoDto>  listaAbonosPorUnidad(@PathVariable int idUnidad){
        return BuilManagerUtils.convertList(abonosServices.obtenerPagosPorUnidad(idUnidad),
                Abono.class, AbonoDto.class, conversionService);
    }

    @GetMapping(value = "/periodo/{periodo}")
    public List<AbonoDto>  listaAbonosPorPeriodo(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodo){
        return BuilManagerUtils.convertList(abonosServices.obtenerPagosPorPeriodo(periodo),
                Abono.class, AbonoDto.class, conversionService);
    }


}
*/
