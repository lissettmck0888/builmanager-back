package com.gi.builmanager.repositorio.projection;

import java.time.LocalDate;

public interface DetalleDeudaUnidadView {
    int getIdDetalleDeudaUnidad();
    float getMonto();
    String getEstado();
    LocalDate getFechaPago();
    UnidadView getUnidad();
    GastoComunView getGastoComun();

}
