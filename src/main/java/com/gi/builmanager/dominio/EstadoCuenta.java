package com.gi.builmanager.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="estado_cuenta")
public class EstadoCuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private LocalDate periodo;
    @Column
    private Double saldo;
    @ManyToOne
    @JoinColumn(name = "id_unidad")
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
