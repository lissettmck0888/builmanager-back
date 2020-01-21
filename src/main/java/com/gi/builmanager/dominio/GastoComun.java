package com.gi.builmanager.dominio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "gasto_comun")
@Entity
public class GastoComun {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgastocomun")
    private Integer idGastoComun;
    @Column
    private String estado;
    @Column
    private Double montoTotal;
    @Column
    private LocalDate periodo;
    @OneToMany(mappedBy = "gastoComun", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleGastoComun> listaDetalleGastoComun;

    public Integer getIdGastoComun() {
        return idGastoComun;
    }

    public void setIdGastoComun(Integer idGastoComun) {
        this.idGastoComun = idGastoComun;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getPeriodo() {
        return periodo;
    }

    public void setPeriodo(LocalDate periodo) {
        this.periodo = periodo;
    }

    public List<DetalleGastoComun> getListaDetalleGastoComun() {
        return listaDetalleGastoComun;
    }

    public void setListaDetalleGastoComun(List<DetalleGastoComun> listaDetalleGastoComun) {
        this.listaDetalleGastoComun = listaDetalleGastoComun;
    }
}
