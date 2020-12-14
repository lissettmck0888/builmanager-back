package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.dominio.Unidad;

import java.time.LocalDate;

public class MovimientoDto {
    private Integer id;
    private LocalDate fecha;
    private Double monto;
    private String tipo;
    private Integer idGastoComun;
    private Unidad idUnidad;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdGastoComun() {
        return idGastoComun;
    }

    public void setIdGastoComun(Integer idGastoComun) {
        this.idGastoComun = idGastoComun;
    }

    public Unidad getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Unidad idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
