package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.Unidad;

public class AsignacionUnidadDto {

    private Unidad unidad;
    private Boolean unidadCopropiedad;

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
