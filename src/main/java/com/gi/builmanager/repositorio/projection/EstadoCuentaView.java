package com.gi.builmanager.repositorio.projection;

import java.time.LocalDate;

public interface EstadoCuentaView {
    int getId();
    float getSaldo();
    UnidadView getUnidad();
    GastoComunView getGastoComun();

}
