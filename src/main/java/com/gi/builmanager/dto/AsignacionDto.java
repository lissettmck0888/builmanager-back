package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.Persona;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AsignacionDto {

    private Integer idAsignacion;
    private Persona persona;
    private String tipoAsignacion;
    private String estado;
    private LocalDate fechaAsignacion;
    private List<UnidadDto> unidades;

}
