package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.Asignacion;
import com.gi.builmanager.dominio.AsignacionUnidad;
import com.gi.builmanager.dto.AsignacionDto;
import com.gi.builmanager.dto.AsignacionUnidadDto;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class AsignacionConverter implements Converter<AsignacionDto, Asignacion> {

    @Override
    public Asignacion convert(AsignacionDto dto) {
        Asignacion asignacion = new Asignacion();
        asignacion.setIdAsignacion(dto.getIdAsignacion());
        asignacion.setIdPersona(dto.getPersona());
        asignacion.setEstado(dto.getEstado());
        asignacion.setTipoAsignacion(dto.getTipoAsignacion());
        asignacion.setAsignacionUnidads(toAsignacionUnidadList(dto.getAsignacionUnidades(), asignacion));
        return asignacion;
    }

    private List<AsignacionUnidad> toAsignacionUnidadList(List<AsignacionUnidadDto> dtoList, Asignacion asignacion) {
        List<AsignacionUnidad> asignacionUnidadList = new ArrayList<>();
        dtoList.stream().forEach(asignacionUnidadDto -> {
            AsignacionUnidad asignacionUnidad = new AsignacionUnidad();
            asignacionUnidad.setAsignacion(asignacion);
            asignacionUnidad.setUnidad(asignacionUnidadDto.getUnidad());
            asignacionUnidad.setUnidadCopropiedad(asignacionUnidadDto.getUnidadCopropiedad());
            asignacionUnidadList.add(asignacionUnidad);
        });
        return asignacionUnidadList;

    }
}
