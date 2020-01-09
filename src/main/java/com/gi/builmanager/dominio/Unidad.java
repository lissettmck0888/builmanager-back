package com.gi.builmanager.dominio;

import javax.persistence.*;

@Table(name = "unidad")
@Entity
public class Unidad {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idunidad")
    private int idUnidad;
    @ManyToOne @JoinColumn(name = "idtipounidad")
    private TipoUnidad tipoUnidad;
    @Column
    private String descripcion;
    @Column
    private int piso;
    @Column
    private String numero;
    @Column
    private String sector;
    @Column
    private float prorrateo;

    public Unidad() {
    }

    public Unidad(String descripcion, int piso, String numero, String sector, float prorrateo) {
        this.descripcion = descripcion;
        this.piso = piso;
        this.numero = numero;
        this.sector = sector;
        this.prorrateo = prorrateo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public float getProrrateo() {
        return prorrateo;
    }

    public void setProrrateo(float prorrateo) {
        this.prorrateo = prorrateo;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public TipoUnidad getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(TipoUnidad tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }
}
