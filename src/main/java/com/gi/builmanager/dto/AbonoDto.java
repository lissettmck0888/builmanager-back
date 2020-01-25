package com.gi.builmanager.dto;


import java.time.LocalDate;

public class AbonoDto {

    private int id;
    private double montoAbono;
    private LocalDate fecha;
    private DetalleDeudaUnidadDto detalleDeudadUnidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontoAbono() {
        return montoAbono;
    }

    public void setMontoAbono(double montoAbono) {
        this.montoAbono = montoAbono;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public DetalleDeudaUnidadDto getDetalleDeudadUnidad() {
        return detalleDeudadUnidad;
    }

    public void setDetalleDeudadUnidad(DetalleDeudaUnidadDto detalleDeudadUnidad) {
        this.detalleDeudadUnidad = detalleDeudadUnidad;
    }
}
