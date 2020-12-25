package com.gi.builmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoDto {
    private Integer id;
    private String fecha;
    private Double monto;
    private String tipo;
    private Integer idGastoComun;
    private Integer idUnidad;

}
