package com.gi.builmanager.dto;

import java.time.LocalDate;

public class DetalleDeudaUnidadDto {

    private Integer idDetalleDeudaUnidad;
    private Double monto;
    private Double factorProrrateo;
    private String estado;
    private LocalDate fechaPago;
    private UnidadDto unidad;
    private GastoComunDto gastoComun;

    public Integer getIdDetalleDeudaUnidad() {
        return idDetalleDeudaUnidad;
    }

    public void setIdDetalleDeudaUnidad(Integer idDetalleDeudaUnidad) {
        this.idDetalleDeudaUnidad = idDetalleDeudaUnidad;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getFactorProrrateo() {
        return factorProrrateo;
    }

    public void setFactorProrrateo(Double factorProrrateo) {
        this.factorProrrateo = factorProrrateo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public UnidadDto getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadDto unidad) {
        this.unidad = unidad;
    }

    public GastoComunDto getGastoComun() {
        return gastoComun;
    }

    public void setGastoComun(GastoComunDto gastoComun) {
        this.gastoComun = gastoComun;
    }
}
