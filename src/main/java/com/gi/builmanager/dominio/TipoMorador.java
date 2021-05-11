package com.gi.builmanager.dominio;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tipo_morador")
@Entity
public class TipoMorador {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipomorador")
    private Integer idTipoMorador;
    @Column
    private String nombre;

}
