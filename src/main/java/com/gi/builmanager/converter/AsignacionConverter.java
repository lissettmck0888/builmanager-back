package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.Asignacion;
import com.gi.builmanager.dominio.AsignacionUnidad;
import com.gi.builmanager.dominio.Unidad;
import com.gi.builmanager.dto.AsignacionDto;
import com.gi.builmanager.dto.AsignacionUnidadDto;
import com.gi.builmanager.dto.UnidadDto;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class AsignacionConverter implements Converter<AsignacionDto, Asignacion> {

    private static AsignacionConverter instance;

    private AsignacionConverter() {}

    public static AsignacionConverter getInstance() {
        return instance == null ? instance = new AsignacionConverter() : instance;
    }

    @Override
    public Asignacion convert(AsignacionDto dto) {
        Asignacion asignacion = new Asignacion();
        asignacion.setIdAsignacion(dto.getIdAsignacion());
        asignacion.setPersona(dto.getPersona());
        asignacion.setEstado(dto.getEstado());
        asignacion.setTipoAsignacion(dto.getTipoAsignacion());
        asignacion.setUnidades(toAsignacionUnidadList(dto.getUnidades(), asignacion));
        return asignacion;
    }

    private List<Unidad> toAsignacionUnidadList(List<UnidadDto> dtoList, Asignacion asignacion) {
        List<Unidad> asignacionUnidadList = new ArrayList<>();
        dtoList.stream().forEach(unidadDto -> {
            Unidad unidad = new Unidad();
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