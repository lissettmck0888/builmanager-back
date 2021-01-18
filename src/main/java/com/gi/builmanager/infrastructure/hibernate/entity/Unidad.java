package com.gi.builmanager.infrastructure.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "unidad")
@Entity
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


    @OneToMany(mappedBy = "unidad", cascade = CascadeType.ALL)
    private List<AsignacionUnidad> asignacionUnidads = new ArrayList<>();

    public Unidad() {
    }

    public Unidad(String descripcion, Integer piso, String numero, String sector, Double metrosCuadrados, Double factorProrrateo) {
        this.descripcion = descripcion;
        this.piso = piso;
        this.numero = numero;
        this.sector = sector;
        this.metrosCuadrados = metrosCuadrados;
        this.factorProrrateo = factorProrrateo;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public TipoUnidad getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(TipoUnidad tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(Double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public Boolean getAfectoProrrateo() {
        return afectoProrrateo;
    }

    public void setAfectoProrrateo(Boolean afectoProrrateo) {
        this.afectoProrrateo = afectoProrrateo;
    }

    public List<AsignacionUnidad> getAsignacionUnidads() {
        return asignacionUnidads;
    }

    public void setAsignacionUnidads(List<AsignacionUnidad> asignacionUnidads) {
        this.asignacionUnidads = asignacionUnidads;
    }

    public Boolean getEsUnidadCopropiedad() {
        return esUnidadCopropiedad;
    }

    public void setEsUnidadCopropiedad(Boolean esUnidadCopropiedad) {
        this.esUnidadCopropiedad = esUnidadCopropiedad;
    }

    public Double getFactorProrrateo() {
        return factorProrrateo;
    }

    public void setFactorProrrateo(Double factorProrrateo) {
        this.factorProrrateo = factorProrrateo;
    }
}
