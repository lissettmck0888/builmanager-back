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

    @Id
    @SequenceGenerator(name = "detalleGasto_pk", sequenceName = "detalle_gasto_comun_iddetallegastocomun_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalleGasto_pk")
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
