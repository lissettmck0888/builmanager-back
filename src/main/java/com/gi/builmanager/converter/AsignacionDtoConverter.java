package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.Asignacion;
import com.gi.builmanager.dominio.Unidad;
import com.gi.builmanager.dto.AsignacionDto;
import com.gi.builmanager.dto.UnidadDto;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class AsignacionDtoConverter implements Converter<Asignacion, AsignacionDto> {

    private static AsignacionDtoConverter instance;

    private AsignacionDtoConverter() {}

    public static AsignacionDtoConverter getInstance() {
        return instance == null ? instance = new AsignacionDtoConverter() : instance;
    }

    @Override
    public AsignacionDto convert(Asignacion dto) {
        AsignacionDto asignacion = new AsignacionDto();
        asignacion.setIdAsignacion(dto.getIdAsignacion());
        asignacion.setPersona(dto.getPersona());
        asignacion.setEstado(dto.getEstado());
        asignacion.setTipoAsignacion(dto.getTipoAsignacion());
        asignacion.setUnidades(toAsignacionUnidadList(dto.getUnidades(), dto));
        return asignacion;
    }

    private List<UnidadDto> toAsignacionUnidadList(List<Unidad> dtoList, Asignacion asignacion) {
        List<UnidadDto> asignacionUnidadList = new ArrayList<>();
        dtoList.stream().forEach(unidadDto -> {
            UnidadDto unidad = new UnidadDto();
            unidad.setIdUnidad(unidadDto.getIdUnidad());
            //unidad.setEsUnidadCopropiedad(unidadDto.);
            unidad.setTipoUnidad(unidadDto.getTipoUnidad());
            unidad.setDescripcion(unidadDto.getDescripcion());
            //unidad.setFactorProrrateo(unidadDto.get);
            unidad.setMetrosCuadrados(unidadDto.getMetrosCuadrados());
            unidad.setAfectoProrrateo(unidadDto.getAfectoProrrateo());
            unidad.setNumero(unidadDto.getNumero());
            unidad.setPiso(unidadDto.getPiso());
            unidad.setSector(unidadDto.getSector());

            asignacionUnidadList.add(unidad);
        });
        return asignacionUnidadList;

    }
}
