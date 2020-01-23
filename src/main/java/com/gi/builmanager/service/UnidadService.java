package com.gi.builmanager.service;

import com.gi.builmanager.dominio.Unidad;
import com.gi.builmanager.repositorio.projection.UnidadView;

import java.util.List;

public interface UnidadService
{
    List<Unidad> getUnidadesDisponiblesSinPropietario();
    List<Unidad> getUnidadesDisponiblesParaArriendo();

}
