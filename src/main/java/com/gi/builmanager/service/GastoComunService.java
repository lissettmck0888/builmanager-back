package com.gi.builmanager.service;

import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.dominio.ItemGastoComun;
import com.gi.builmanager.dominio.PlantillaGastosOrdinarios;
import com.gi.builmanager.dto.EstadoCuentaDto;

import java.time.LocalDate;
import java.util.List;

public interface GastoComunService {

    GastoComun actualizar(GastoComun gastoComun);
    GastoComun getGastoComunAbierto();
    List<GastoComun> getGastoComun();
    GastoComun cerrarGastoComun(GastoComun gastoComun);
    List<EstadoCuentaDto> prorratearGastosPeriodo();

    ItemGastoComun guardarItem(ItemGastoComun itemGastoComun);
    List<ItemGastoComun> getItems(String tipo);

    List<PlantillaGastosOrdinarios> getPlantillaGastosOrdinarios();

    LocalDate getPeriodoActual();
}
