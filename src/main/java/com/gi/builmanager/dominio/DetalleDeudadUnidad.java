package com.gi.builmanager.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "detalle_deuda_unidad")
@Entity
public class DetalleDeudadUnidad {
    @Id @Column(name = "iddetalledeuda")
    private Integer idDetalleDeudaUnidad;
    @Column
    private Double monto;
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

    public DetalleDeudadUnidad(Integer idDetalleDeudaUnidad, Double monto, String estado, LocalDate fechaPago, Unidad unidad, GastoComun gastoComun) {
        this.idDetalleDeudaUnidad = idDetalleDeudaUnidad;
        this.monto = monto;
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.unidad = unidad;
        this.gastoComun = gastoComun;
    }

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
