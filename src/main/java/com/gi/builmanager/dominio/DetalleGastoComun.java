package com.gi.builmanager.dominio;

import javax.persistence.*;

@Table(name = "detalle_gasto_comun")
@Entity
public class DetalleGastoComun {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetallegastocomun")
    private Integer idDetalleGastoComun;
    @Column
    private Double monto;
    @ManyToOne @JoinColumn(name = "idgastocomun")
    private GastoComun gastoComun;
    @ManyToOne @JoinColumn(name = "iditemgastocomun")
    private ItemGastoComun itemGastoComun;

    public Integer getIdDetalleGastoComun() {
        return idDetalleGastoComun;
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
