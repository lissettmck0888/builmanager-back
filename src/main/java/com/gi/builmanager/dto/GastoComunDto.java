package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.DetalleGastoComun;

import java.time.LocalDate;
import java.util.List;

public class GastoComunDto {
    private int idGastoComun;
    private String estado;
    private float montoTotal;
    private LocalDate periodo;
    private float interesMora;
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

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float monto) {
        this.montoTotal = monto;
    }

    public LocalDate getPeriodo() {
        return periodo;
    }

    public void setPeriodo(LocalDate periodo) {
        this.periodo = periodo;
    }

    public float getInteresMora() {
        return interesMora;
    }

    public void setInteresMora(float interesMora) {
        this.interesMora = interesMora;
    }

    public List<DetalleGastoComunDto> getListaDetalleGastoComunDto() {
        return listaDetalleGastoComun;
    }

    public void setListaDetalleGastoComunDto(List<DetalleGastoComunDto> listaDetalleGastoComun) {
        this.listaDetalleGastoComun = listaDetalleGastoComun;
    }
}
