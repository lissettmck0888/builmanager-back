package com.gi.builmanager.dominio;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
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
    private Double totalMetrosCuadradosProrrateables;

    @OneToMany(mappedBy = "asignacion", cascade = CascadeType.ALL)
    private List<AsignacionUnidad> asignacionUnidads = new ArrayList<>();

    public List<AsignacionUnidad> getAsignacionUnidads() {
        return asignacionUnidads;
    }

    public void setAsignacionUnidads(List<AsignacionUnidad> asignacionUnidads) {
        this.asignacionUnidads = asignacionUnidads;
    }
/*

    public Asignacion() {
    }

    public Asignacion(Integer idAsignacion, Persona persona,  String tipoAsignacion, String estado, LocalDateTime fechaAsignacion) {
        this.idAsignacion = idAsignacion;
        this.persona = persona;

        this.tipoAsignacion = tipoAsignacion;
        this.estado = estado;
        this.fechaAsignacion = fechaAsignacion;
    }
*/

}
