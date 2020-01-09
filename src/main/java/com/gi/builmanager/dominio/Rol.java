package com.gi.builmanager.dominio;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "rol")
@Entity
public class Rol {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private int idRol;
    @Column
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "relacion_rol_permiso",
            joinColumns={@JoinColumn(name="idrol")},
            inverseJoinColumns={@JoinColumn(name="idpermiso")})
    private Set<Permiso> permisos = new HashSet<>();

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

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }
}
