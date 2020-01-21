package com.gi.builmanager.dto;

import java.time.LocalDate;
import java.util.List;

public class GastoComunDto {
    private Integer idGastoComun;
    private String estado;
    private Double montoTotal;
    private LocalDate periodo;

    private List<DetalleGastoComunDto> listaDetalleGastoComun;

    public int getIdGastoComun() {
        return idGastoComun;
    }

    public void setIdGastoComun(int idGastoComun) {
        this.idGastoComun = idGastoComun;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getPeriodo() {
        return periodo;
    }

    public void setPeriodo(LocalDate periodo) {
        this.periodo = periodo;
    }

    public List<DetalleGastoComunDto> getListaDetalleGastoComunDto() {
        return listaDetalleGastoComun;
    }

    public void setListaDetalleGastoComunDto(List<DetalleGastoComunDto> listaDetalleGastoComun) {
        this.listaDetalleGastoComun = listaDetalleGastoComun;
    }

    public void setIdGastoComun(Integer idGastoComun) {
        this.idGastoComun = idGastoComun;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<DetalleGastoComunDto> getListaDetalleGastoComun() {
        return listaDetalleGastoComun;
    }

    public void setListaDetalleGastoComun(List<DetalleGastoComunDto> listaDetalleGastoComun) {
        this.listaDetalleGastoComun = listaDetalleGastoComun;
    }
}
