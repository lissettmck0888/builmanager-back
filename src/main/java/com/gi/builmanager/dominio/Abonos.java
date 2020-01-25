package com.gi.builmanager.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Table (name = "abono")
@Entity
public class Abonos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private double montoAbono;
    @Column
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "iddetalledeuda")
    private DetalleDeudadUnidad detalleDeudadUnidad;

    public Abonos() {
    }

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

    public DetalleDeudadUnidad getDetalleDeudadUnidad() {
        return detalleDeudadUnidad;
    }

    public void setDetalleDeudadUnidad(DetalleDeudadUnidad detalleDeudadUnidad) {
        this.detalleDeudadUnidad = detalleDeudadUnidad;
    }

}
