package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.Unidad;

import java.time.LocalDate;

public class EstadoCuentaDto {
    private Integer id;
    private LocalDate periodo;
    private Double saldo;
    private Unidad unidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getPeriodo() {
        return periodo;
    }

    public void setPeriodo(LocalDate periodo) {
        this.periodo = periodo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
