package com.gi.builmanager.infrastructure.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="estado_cuenta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoCuenta {
    @Id
    @SequenceGenerator(name = "estadoCuenta_pk", sequenceName = "estado_cuenta_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estadoCuenta_pk")
    @Column
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "gasto_comun")
    private GastoComun gastoComun;
    @ManyToOne
    @JoinColumn(name = "id_unidad")
    private Unidad unidad;
    @Column(name = "factor")
    private Double factorProrrateo;
    @Column(name = "monto_anterior")
    private Double montoAnterior;
    @Column(name = "monto_inicial")
    private Double montoInicial;
    @Column(name = "total_periodo")
    private Double totalPeriodo;
    @Column
    private Double abonos;
    @Column
    private Double saldo;



}
