package com.gi.builmanager.infrastructure.hibernate.repository.projection;

public interface DetalleGastoComunView {

    Integer getIdDetalleGastoComun();
    Float getMonto();
    Integer getGastoComun();
    ItemGastoComunView getItemGastoComun();
}
