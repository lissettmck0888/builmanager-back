package com.gi.builmanager.dominio;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "unidad")
@Entity
@Data
public class Unidad {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idunidad")
    private Integer idUnidad;
    @ManyToOne @JoinColumn(name = "idtipounidad")
    private TipoUnidad tipoUnidad;
    @Column
    private String descripcion;
    @Column
    private Integer piso;
    @Column
    private String numero;
    @Column
    private String sector;
    @Column(name = "metros_cuadrados")
    private Double metrosCuadrados;
    @Column(name = "afecto_prorrateo")
    private Boolean afectoProrrateo;
    @Column(name = "es_unidad_copropiedad")
    private Boolean esUnidadCopropiedad;
    @Column
    private Double factorProrrateo;

}
