package com.gi.builmanager.service;

import com.gi.builmanager.dominio.Abono;
import com.gi.builmanager.dominio.Movimiento;

import java.time.LocalDate;
import java.util.List;

public interface AbonosServices {
     Movimiento registrarAbono(Double monto, Integer idUnidad, Integer idGastoComun);
     /*List<Movimiento> obtenerPagosPorUnidad(Integer idUnidad);
     List<Movimiento> obtenerPagosPorPeriodo(LocalDate periodo);*/


}
