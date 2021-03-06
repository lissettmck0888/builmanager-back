package com.gi.builmanager.security.authentication.repository.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "permiso")
@Entity
public class Permiso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpermiso")
    private Integer idPermiso;
    @Column
    private String codigo;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @ManyToMany(mappedBy = "permisos")
    private Set<Rol> roles = new HashSet<>();

    public Permiso() {
    }

    public Permiso(Integer idPermiso, String codigo, String nombre, String descripcion) {
        this.idPermiso = idPermiso;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
