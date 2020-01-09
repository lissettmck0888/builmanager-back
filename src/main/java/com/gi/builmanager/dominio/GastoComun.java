package com.gi.builmanager.dominio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "gasto_comun")
@Entity
public class GastoComun {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgastocomun")
    int idGastoComun;
    @Column
    String estado;
    @Column
    float montoTotal;
    @Column
    LocalDate periodo;
    @Column
    int interesMora;
    @OneToMany(mappedBy = "gastoComun")
    private List<DetalleGastoComun> listaDetalleGastoComun;

    public GastoComun() {
    }

    public GastoComun(String estado, float montoTotal, LocalDate periodo, int interesMora) {
        this.estado = estado;
        this.montoTotal = montoTotal;
        this.periodo = periodo;
        this.interesMora = interesMora;
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

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getPeriodo() {
        return periodo;
    }

    public void setPeriodo(LocalDate periodo) {
        this.periodo = periodo;
    }

    public int getInteresMora() {
        return interesMora;
    }

    public void setInteresMora(int interesMora) {
        this.interesMora = interesMora;
    }

    public int getIdGastoComun() {
        return idGastoComun;
    }

    public void setIdGastoComun(int idGastoComun) {
        this.idGastoComun = idGastoComun;
    }

    public List<DetalleGastoComun> getListaDetalleGastoComun() {
        return listaDetalleGastoComun;
    }

    public void setListaDetalleGastoComun(List<DetalleGastoComun> listaDetalleGastoComun) {
        this.listaDetalleGastoComun = listaDetalleGastoComun;
    }
}
