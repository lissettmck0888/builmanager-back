package com.gi.builmanager.infrastructure.hibernate.entity;

import javax.persistence.*;

@Table(name = "plantilla_gastos_ordinarios")
@Entity
public class PlantillaGastosOrdinarios {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne @JoinColumn(name = "iditemgastocomun")
    private ItemGastoComun itemGastoComun;
    @Column
    private Double monto;
    @Column
    private Boolean activo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemGastoComun getItemGastoComun() {
        return itemGastoComun;
    }

    public void setItemGastoComun(ItemGastoComun itemGastoComun) {
        this.itemGastoComun = itemGastoComun;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
