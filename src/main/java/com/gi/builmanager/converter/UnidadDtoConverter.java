package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.Unidad;
import com.gi.builmanager.dto.UnidadDto;
import org.springframework.core.convert.converter.Converter;

public class UnidadDtoConverter implements Converter<Unidad, UnidadDto> {

    private static UnidadDtoConverter instance;

    private UnidadDtoConverter() {}

    public static UnidadDtoConverter getInstance() {
        return instance == null ? instance = new UnidadDtoConverter() : instance;
    }

    @Override
    public UnidadDto convert(Unidad unidad) {
        UnidadDto dto = new UnidadDto();
        dto.setIdUnidad(unidad.getIdUnidad());
        dto.setTipoUnidad(unidad.getTipoUnidad());
        dto.setAfectoProrrateo(unidad.getAfectoProrrateo());
        dto.setDescripcion(unidad.getDescripcion());
        dto.setMetrosCuadrados(unidad.getMetrosCuadrados());
        dto.setNumero(unidad.getNumero());
        dto.setPiso(unidad.getPiso());
        dto.setSector(unidad.getSector());
        dto.setEsUnidadCopropiedad(unidad.getEsUnidadCopropiedad());
        dto.setFactorProrrateo(unidad.getFactorProrrateo());

        return dto;
    }
}
