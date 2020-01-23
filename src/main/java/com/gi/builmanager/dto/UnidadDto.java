package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.TipoUnidad;

public class UnidadDto {

    private Integer idUnidad;
    private TipoUnidad tipoUnidad;
    private String descripcion;
    private Integer piso;
    private String numero;
    private String sector;
    private Double metrosCuadrados;
    private Boolean afectoProrrateo;

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
}
