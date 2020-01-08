package com.gi.builmanager.repositorio.projection;

import com.gi.builmanager.dominio.TipoUnidad;

public interface UnidadView {
    int getIdUnidad();
    TipoUnidad getTipoUnidad();
    int getNumero();
    float getProrrateo();
}
