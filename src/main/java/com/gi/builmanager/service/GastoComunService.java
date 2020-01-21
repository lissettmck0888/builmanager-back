package com.gi.builmanager.service;

import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.dominio.ItemGastoComun;
import com.gi.builmanager.repositorio.projection.GastoComunView;

import java.util.List;

public interface GastoComunService {

    GastoComunView getGastoComunAbierto();
    List<GastoComun> getGastoComun();

    ItemGastoComun guardarItem(ItemGastoComun itemGastoComun);
    List<ItemGastoComun> getItems();
}
