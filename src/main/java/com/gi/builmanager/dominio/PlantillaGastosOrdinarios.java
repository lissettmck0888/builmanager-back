package com.gi.builmanager.dominio;

import lombok.Data;

import javax.persistence.*;

@Data
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

}
