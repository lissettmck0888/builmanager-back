package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.dominio.ItemGastoComun;
import com.gi.builmanager.dto.GastoComunDto;
import com.gi.builmanager.repositorio.projection.GastoComunView;
import com.gi.builmanager.service.GastoComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/gasto-comun")
public class GastoComunController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private GastoComunService gastoComunService;

    @GetMapping("/abierto")
    public GastoComunView obtenerGastoComunAbierto() {
        return gastoComunService.getGastoComunAbierto();
    }

    @GetMapping("/")
    public List<GastoComunDto> getGastoComun(){
        return (List<GastoComunDto>) conversionService.convert(
                gastoComunService.getGastoComun(),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(GastoComun.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(GastoComunDto.class)));
    }

    @PostMapping("/item/")
    public ItemGastoComun guardarItem(@RequestBody ItemGastoComun itemGastoComun){
        return gastoComunService.guardarItem(itemGastoComun);
    }

    @GetMapping("/item/")
    public List<ItemGastoComun> getAllItems(){
        return gastoComunService.getItems();
    }
}
