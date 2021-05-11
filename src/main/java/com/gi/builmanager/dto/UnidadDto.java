package com.gi.builmanager.dto;

import com.gi.builmanager.dominio.TipoUnidad;
import lombok.Data;

@Data
public class UnidadDto {

    private Integer idUnidad;
    private TipoUnidad tipoUnidad;
    private String descripcion;
    private Integer piso;
    private String numero;
    private String sector;
    private Double metrosCuadrados;
    private Boolean afectoProrrateo;
    private Boolean esUnidadCopropiedad;
    private Double factorProrrateo;

}
