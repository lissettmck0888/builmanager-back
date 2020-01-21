package com.gi.builmanager.repositorio.projection;

public interface DetalleGastoComunView {

    Integer getIdDetalleGastoComun();
    Float getMonto();
    Integer getGastoComun();
    ItemGastoComunView getItemGastoComun();
}
