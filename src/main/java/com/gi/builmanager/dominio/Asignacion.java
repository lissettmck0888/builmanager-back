package com.gi.builmanager.dominio;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "asignacion")
@Entity
@Data
public class Asignacion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idAsignacion;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idpersona")
    private Persona persona;
    @Column
    private String tipoAsignacion;
    @Column
    private String estado;
    @Column
    private LocalDateTime fechaAsignacion;
    @Column
    private LocalDateTime fechaFin;
    @Column
    private Double totalMetrosCuadradosProrrateables;
    @Column
    private Boolean ocupado;
    @ManyToOne
    @JoinColumn(name = "parent")
    private Asignacion parent;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "asignacion_unidad",
            joinColumns = {@JoinColumn(name = "id_asignacion")},
            inverseJoinColumns = {@JoinColumn(name = "id_unidad")}
    )
    private List<Unidad> unidades;

    /*FIXME: BORRAR COLUMNA UNIDAD_COPROPIEDAD DE ASIGNACION_UNIDAD*/
}
