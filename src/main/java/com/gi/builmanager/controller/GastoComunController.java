package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.DetalleDeudadUnidad;
import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.dominio.ItemGastoComun;
import com.gi.builmanager.dominio.PlantillaGastosOrdinarios;
import com.gi.builmanager.dto.DetalleDeudaUnidadDto;
import com.gi.builmanager.dto.GastoComunDto;
import com.gi.builmanager.service.GastoComunService;
import com.gi.builmanager.util.BuilManagerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/gasto-comun")
@CrossOrigin(origins = {"*"})
public class GastoComunController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GastoComunController.class);

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private GastoComunService gastoComunService;

    @PostMapping("/cerrar")
    public GastoComunDto cerrarGastoComunPeriodo() {
        return conversionService.convert(gastoComunService.cerrarGastoComun(), GastoComunDto.class);
    }

    @PostMapping("/prorratear")
    public List<DetalleDeudaUnidadDto> prorratearGastoComunPeriodo() {
        return BuilManagerUtils.convertList(gastoComunService.prorratearGastosPeriodo(),
                DetalleDeudadUnidad.class, DetalleDeudaUnidadDto.class, conversionService);
    }

    @GetMapping("/abierto")
    public GastoComunDto obtenerGastoComunAbierto() {
        return conversionService.convert(gastoComunService.getGastoComunAbierto(), GastoComunDto.class);
    }

    @GetMapping("/")
    public List<GastoComunDto> getGastoComun(){
        return BuilManagerUtils.convertList(
                gastoComunService.getGastoComun(),
                GastoComun.class,
                GastoComunDto.class,
                conversionService
        );
    }

    @PostMapping("/")
    public GastoComunDto actualizarGastoComun(@RequestBody GastoComunDto gastoComun){
        LOGGER.info("llega aqui...");
        GastoComun updated = gastoComunService.actualizar(conversionService.convert(gastoComun, GastoComun.class));
        return conversionService.convert(updated, GastoComunDto.class);
    }

    @GetMapping("/item/")
    public List<ItemGastoComun> getAllItems(){
        return gastoComunService.getItems();
    }


    @GetMapping("/plantilla/")
    public List<PlantillaGastosOrdinarios> getPlantillaGastosOrdinarios(){
        return gastoComunService.getPlantillaGastosOrdinarios();
    }
}
