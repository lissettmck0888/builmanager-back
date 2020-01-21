package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.ItemGastoComun;

public class DetalleGastoComunDto {
    private  Integer idDetalleGastoComun;
    private Double monto;
    private ItemGastoComunDto itemGastoComunDto;

    public int getIdDetalleGastoComun() {
        return idDetalleGastoComun;
    }

    public void setIdDetalleGastoComun(int idDetalleGastoComun) {
        this.idDetalleGastoComun = idDetalleGastoComun;
    }

    public ItemGastoComunDto getItemGastoComunDto() {
        return itemGastoComunDto;
    }

    public void setIdDetalleGastoComun(Integer idDetalleGastoComun) {
        this.idDetalleGastoComun = idDetalleGastoComun;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setItemGastoComunDto(ItemGastoComunDto itemGastoComun) {
        this.itemGastoComunDto = itemGastoComun;
    }
}
