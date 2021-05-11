package com.gi.builmanager.repositorio.projection;

import com.gi.builmanager.dominio.TipoUnidad;

public interface UnidadView {
    Integer getIdUnidad();
    TipoUnidad getTipoUnidad();
    String getNumero();
    Integer getPiso();
    String getSector();
    Double getMetrosCuadrados();
    Boolean getAfectoProrrateo();
    Boolean getEsUnidadCopropiedad();
    Double getFactorProrrateo();
}
