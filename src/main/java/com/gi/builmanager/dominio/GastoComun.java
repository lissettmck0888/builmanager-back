package com.gi.builmanager.dominio;

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
    @OneToMany(targetEntity = DetalleGastoComun.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idgastocomun")
    private List<DetalleGastoComun> listaDetalleGastoComun;

}
