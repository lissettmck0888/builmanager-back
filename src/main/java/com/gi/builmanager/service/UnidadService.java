package com.gi.builmanager.service;

import com.gi.builmanager.dominio.Unidad;

import java.util.List;

public interface UnidadService
{
    List<Unidad> getUnidadesDisponiblesSinPropietario(Boolean unidadCopropiedad);
    List<Unidad> getUnidadesDisponiblesParaArriendo();

}
