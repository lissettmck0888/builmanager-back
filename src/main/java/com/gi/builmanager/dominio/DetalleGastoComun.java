package com.gi.builmanager.dominio;

import javax.persistence.*;

@Table(name = "detalle_gasto_comun")
@Entity
public class DetalleGastoComun {
    @Id @Column(name = "iddetallegastocomun")
    private int idDetalleGastoComun;
    @Column
    private float monto;
    @ManyToOne @JoinColumn(name = "idgastocomun")
    private GastoComun gastoComun;
    @ManyToOne @JoinColumn(name = "iditemgastocomun")
    private ItemGastoComun itemGastoComun;

    public DetalleGastoComun() {
    }

    public DetalleGastoComun(int idDetalleGastoComun, float monto, GastoComun gastoComun, ItemGastoComun itemGastoComun) {
        this.idDetalleGastoComun = idDetalleGastoComun;
        this.monto = monto;
        this.gastoComun = gastoComun;
        this.itemGastoComun = itemGastoComun;
    }

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

    public GastoComun getGastoComun() {
        return gastoComun;
    }

    public void setGastoComun(GastoComun gastoComun) {
        this.gastoComun = gastoComun;
    }

    public ItemGastoComun getItemGastoComun() {
        return itemGastoComun;
    }

    public void setItemGastoComun(ItemGastoComun itemGastoComun) {
        this.itemGastoComun = itemGastoComun;
    }

}
