package com.gi.builmanager.service;

import com.gi.builmanager.repositorio.projection.DetalleDeudaUnidadView;

import java.util.List;

public interface DetalleDeudaUnidadService {

    List<DetalleDeudaUnidadView> getByUnidad(int idUnidad);
}
