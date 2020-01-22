package com.gi.builmanager.dominio;

import javax.persistence.*;

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
    @Column
    private Double rating;

    public Unidad() {
    }

    public Unidad(String descripcion, Integer piso, String numero, String sector, Double rating) {
        this.descripcion = descripcion;
        this.piso = piso;
        this.numero = numero;
        this.sector = sector;
        this.rating = rating;
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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
}
