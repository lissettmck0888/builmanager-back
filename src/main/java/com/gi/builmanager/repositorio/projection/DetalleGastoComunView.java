package com.gi.builmanager.repositorio.projection;

public interface DetalleGastoComunView {

    Integer getIdDetalleGastoComun();
    Float getMonto();
    GastoComunView getGastoComun();
    ItemGastoComunView getItemGastoComun();
}
