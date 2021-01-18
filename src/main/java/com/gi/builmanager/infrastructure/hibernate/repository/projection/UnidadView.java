package com.gi.builmanager.infrastructure.hibernate.repository.projection;


import com.gi.builmanager.infrastructure.hibernate.entity.TipoUnidad;

public interface UnidadView {
    Integer getIdUnidad();
    TipoUnidad getTipoUnidad();
    String getNumero();
    Integer getPiso();
    String getSector();
    Double getMetrosCuadrados();
    Boolean getAfectoProrrateo();
}
