package com.gi.builmanager.infrastructure.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "asignacion_unidad")
@Entity
public class AsignacionUnidad implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_asignacion")
    private Asignacion asignacion;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_unidad")
    private Unidad unidad;

    @Column
    private Boolean unidadCopropiedad;

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public Boolean getUnidadCopropiedad() {
        return unidadCopropiedad;
    }

    public void setUnidadCopropiedad(Boolean unidadCopropiedad) {
        this.unidadCopropiedad = unidadCopropiedad;
    }
}
