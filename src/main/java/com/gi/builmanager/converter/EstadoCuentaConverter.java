package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.EstadoCuenta;
import com.gi.builmanager.dto.EstadoCuentaDto;
import org.springframework.core.convert.converter.Converter;

public class EstadoCuentaConverter implements Converter<EstadoCuenta, EstadoCuentaDto> {

    private final GastoComunDtoConverter gastoComunDtoConverter = GastoComunDtoConverter.getInstance();
    private final UnidadDtoConverter unidadDtoConverter = UnidadDtoConverter.getInstance();
    private final AsignacionDtoConverter asignacionDtoConverter = AsignacionDtoConverter.getInstance();


    private static EstadoCuentaConverter instance;

    private EstadoCuentaConverter() {}

    public static EstadoCuentaConverter getInstance() {
        return instance == null ? instance = new EstadoCuentaConverter() : instance;
    }

    @Override
    public EstadoCuentaDto convert(EstadoCuenta estadoCuenta){
        return EstadoCuentaDto.of(estadoCuenta);
    }
}
