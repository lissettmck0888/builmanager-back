package com.gi.builmanager.dto;

public class DetalleGastoComunDto {
    private  Integer idDetalleGastoComun;
    private Double monto;
    private Integer gastoComun;
    private ItemGastoComunDto itemGastoComun;

    public Integer getGastoComun() {
        return gastoComun;
    }

    public void setGastoComun(Integer gastoComun) {
        this.gastoComun = gastoComun;
    }

    public Integer getIdDetalleGastoComun() {
        return idDetalleGastoComun;
    }

    public void setIdDetalleGastoComun(Integer idDetalleGastoComun) {
        this.idDetalleGastoComun = idDetalleGastoComun;
    }

    public ItemGastoComunDto getItemGastoComun() {
        return itemGastoComun;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setItemGastoComun(ItemGastoComunDto itemGastoComun) {
        this.itemGastoComun = itemGastoComun;
    }
}
