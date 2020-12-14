package com.gi.builmanager.service;

import com.gi.builmanager.dominio.*;
import com.gi.builmanager.repositorio.projection.GastoComunView;

import java.time.LocalDate;
import java.util.List;

public interface GastoComunService {

    GastoComun actualizar(GastoComun gastoComun);
    GastoComun getGastoComunAbierto();
    List<GastoComun> getGastoComun();
    GastoComun cerrarGastoComun(GastoComun gastoComun);
    List<Movimiento> prorratearGastosPeriodo();

    ItemGastoComun guardarItem(ItemGastoComun itemGastoComun);
    List<ItemGastoComun> getItems(String tipo);

    List<PlantillaGastosOrdinarios> getPlantillaGastosOrdinarios();

    LocalDate getPeriodoActual();
}
