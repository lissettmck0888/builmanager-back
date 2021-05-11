package com.gi.builmanager.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="movimiento")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movimiento {
    @Id
    @SequenceGenerator(name = "movimiento_pk", sequenceName = "movimiento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimiento_pk")
    @Column
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_asignacion")
    private Asignacion asignacion;
    @ManyToOne
    @JoinColumn(name = "id_gastocomun")
    private GastoComun gastoComun;
    @Column
    private String tipo;
    @Column
    private Double monto;
    @Column
    private LocalDateTime fecha;


}
