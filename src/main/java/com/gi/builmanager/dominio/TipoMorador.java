package com.gi.builmanager.dominio;
import javax.persistence.*;

@Table(name = "tipo_morador")
@Entity
public class TipoMorador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipomorador")
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
