package com.gi.builmanager.infrastructure.hibernate.repository.projection;

import java.time.LocalDate;
import java.util.List;

public interface GastoComunView {

    Integer getIdGastoComun();
    String getEstado();
    Float getMontoTotal();
    LocalDate getPeriodo();
    List<DetalleGastoComunView> getListaDetalleGastoComun();
}
