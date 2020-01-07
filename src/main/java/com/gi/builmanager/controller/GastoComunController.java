package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.dto.GastoComunDto;
import com.gi.builmanager.service.GastoComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/gastoscomunes")
public class GastoComunController {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private GastoComunService gastoComunService;
    @GetMapping("/")
    public List<GastoComunDto> getGastoComun(){
        return (List<GastoComunDto>) conversionService.convert(
                gastoComunService.getGastoComun(),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(GastoComun.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(GastoComunDto.class)));
    }

}
