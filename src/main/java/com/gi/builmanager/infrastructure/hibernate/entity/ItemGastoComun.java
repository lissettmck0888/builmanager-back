package com.gi.builmanager.infrastructure.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_gasto_comun")
@Entity
@ToString
public class ItemGastoComun {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iditemgastocomun")
    private Integer idItemGastoComun;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String tipo;

}
