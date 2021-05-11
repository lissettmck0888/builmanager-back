package com.gi.builmanager.repositorio.projection;

import java.time.LocalDate;

public interface EstadoCuentaView {
    int getId();
    float getSaldo();
    AsignacionView getAsignacion();
    GastoComunView getGastoComun();

}
