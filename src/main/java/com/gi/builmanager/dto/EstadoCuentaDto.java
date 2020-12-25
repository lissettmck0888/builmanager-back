package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.Unidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoCuentaDto {
    private Integer id;
    private Integer gastoComun;
    private Double saldo;
    private Unidad unidad;

}
