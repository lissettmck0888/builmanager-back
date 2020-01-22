package com.gi.builmanager.service;

import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.dominio.ItemGastoComun;
import com.gi.builmanager.dominio.PlantillaGastosOrdinarios;
import com.gi.builmanager.repositorio.projection.GastoComunView;

import java.util.List;

public interface GastoComunService {

    GastoComun actualizar(GastoComun gastoComun);
    GastoComun getGastoComunAbierto();
    List<GastoComun> getGastoComun();
    GastoComun cerrarGastoComunPeriodo();

    ItemGastoComun guardarItem(ItemGastoComun itemGastoComun);
    List<ItemGastoComun> getItems();

    List<PlantillaGastosOrdinarios> getPlantillaGastosOrdinarios();
}
