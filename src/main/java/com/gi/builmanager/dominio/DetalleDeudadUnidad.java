package com.gi.builmanager.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "detalle_deuda_unidad")
@Entity
public class DetalleDeudadUnidad {
    @Id @Column(name = "iddetalledeuda")
    private int idDetalleDeudaUnidad;
    @Column
    private float monto;
    @Column
    private String estado;
    @Column
    private LocalDate fechaPago;
    @ManyToOne @JoinColumn(name = "idunidad")
    private  Unidad unidad;
    @ManyToOne @JoinColumn(name = "idgastocomun")
    private GastoComun gastoComun;

    public DetalleDeudadUnidad() {
    }

    public DetalleDeudadUnidad(int idDetalleDeudaUnidad, float monto, String estado, LocalDate fechaPago, Unidad unidad, GastoComun gastoComun) {
        this.idDetalleDeudaUnidad = idDetalleDeudaUnidad;
        this.monto = monto;
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.unidad = unidad;
        this.gastoComun = gastoComun;
    }

    public int getIdDetalleDeudaUnidad() {
        return idDetalleDeudaUnidad;
    }

    public void setIdDetalleDeudaUnidad(int idDetalleDeudaUnidad) {
        this.idDetalleDeudaUnidad = idDetalleDeudaUnidad;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
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

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public GastoComun getGastoComun() {
        return gastoComun;
    }

    public void setGastoComun(GastoComun gastoComun) {
        this.gastoComun = gastoComun;
    }
}
