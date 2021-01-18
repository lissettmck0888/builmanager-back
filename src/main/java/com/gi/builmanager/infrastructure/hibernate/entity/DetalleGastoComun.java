package com.gi.builmanager.infrastructure.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detalle_gasto_comun")
@Entity
@ToString(exclude = {"gastoComun"})
public class DetalleGastoComun {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetallegastocomun")
    private Integer idDetalleGastoComun;

    @Column
    private Double monto;

    @ManyToOne @JoinColumn(name = "idgastocomun")
    private GastoComun gastoComun;

    @ManyToOne @JoinColumn(name = "iditemgastocomun")
    //private ItemGastoComun itemGastoComun;
    private ItemGastoComun itemGastoComun;

}
