package com.gi.builmanager.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="movimientos")
public class Movimiento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_unidad")
    private Unidad unidad;
    @ManyToOne
    @JoinColumn(name = "id_gastocomun")
    private GastoComun gastoComun;
    @Column
    private String tipo;
    @Column
    private Double monto;
    @Column
    private LocalDate fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
