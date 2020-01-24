package com.gi.builmanager.service;

import com.gi.builmanager.dominio.Abono;

import java.time.LocalDate;
import java.util.List;

public interface AbonosServices {
     Abono registrarPagos(Abono abono);
     List<Abono> obtenerPagosPorUnidad(Integer idUnidad);
     List<Abono> obtenerPagosPorPeriodo(LocalDate periodo);


}
