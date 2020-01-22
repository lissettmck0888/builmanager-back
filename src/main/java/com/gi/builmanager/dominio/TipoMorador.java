package com.gi.builmanager.dominio;
import javax.persistence.*;

@Table(name = "tipo_morador")
@Entity
public class TipoMorador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipomorador")
    private Integer idTipoMorador;
    @Column
    private String nombre;

    public TipoMorador() {
    }

    public TipoMorador(Integer idTipoMorador, String nombre) {
        this.idTipoMorador = idTipoMorador;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTipoMorador() {
        return idTipoMorador;
    }

    public void setIdTipoMorador(Integer idTipoMorador) {
        this.idTipoMorador = idTipoMorador;
    }
}
