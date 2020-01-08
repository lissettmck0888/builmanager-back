package com.gi.builmanager.dominio;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tipo_morador")
@Entity
public class TipoMorador {
    @Id @Column(name = "idtipomorador")
    private int idTipoMorador;
    @Column
    private String nombre;

    public TipoMorador() {
    }

    public TipoMorador(int idTipoMorador, String nombre) {
        this.idTipoMorador = idTipoMorador;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipoMorador() {
        return idTipoMorador;
    }

    public void setIdTipoMorador(int idTipoMorador) {
        this.idTipoMorador = idTipoMorador;
    }
}
