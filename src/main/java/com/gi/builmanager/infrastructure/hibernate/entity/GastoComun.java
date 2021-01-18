package com.gi.builmanager.infrastructure.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gasto_comun")
@Entity
@ToString
public class GastoComun {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgastocomun")
    private Integer idGastoComun;
    @Column
    private String estado;
    @Column
    private Double montoTotal;
    @Column
    private LocalDate periodo;
    @OneToMany(mappedBy = "gastoComun", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleGastoComun> listaDetalleGastoComun;

}
