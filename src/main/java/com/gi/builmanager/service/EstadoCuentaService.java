package com.gi.builmanager.service;

import com.gi.builmanager.dominio.EstadoCuenta;
import com.gi.builmanager.repositorio.projection.EstadoCuentaView;

import java.time.LocalDate;
import java.util.List;

public interface EstadoCuentaService {

    List<EstadoCuentaView> getByUnidad(int idUnidad);
    List<EstadoCuenta> getByPeriodo(LocalDate periodo);

}
