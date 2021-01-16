package com.gi.builmanager.security.authentication.repositorio.dominio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "rol")
@Entity
public class Rol {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Integer idRol;
    @Column
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "relacion_rol_permiso",
            joinColumns={@JoinColumn(name="idrol")},
            inverseJoinColumns={@JoinColumn(name="idpermiso")})
    private List<Permiso> permisos = new ArrayList<>();

    public Rol() {
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }
}
