package com.gi.builmanager.dominio;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tipo_unidad")
@Entity
public class TipoUnidad {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipounidad")
    private Integer idTipoUnidad;
    @Column
    private String nombre;

}
