package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.ItemGastoComun;

public class DetalleGastoComunDto {
    private  int idDetalleGastoComun;
    private float monto;
    private ItemGastoComunDto itemGastoComunDto;

    public int getIdDetalleGastoComun() {
        return idDetalleGastoComun;
    }

    public void setIdDetalleGastoComun(int idDetalleGastoComun) {
        this.idDetalleGastoComun = idDetalleGastoComun;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public ItemGastoComunDto getItemGastoComunDto() {
        return itemGastoComunDto;
    }

    public void setItemGastoComunDto(ItemGastoComunDto itemGastoComun) {
        this.itemGastoComunDto = itemGastoComun;
    }
}
