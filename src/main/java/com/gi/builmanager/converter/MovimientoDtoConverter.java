package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.Movimiento;
import com.gi.builmanager.dto.MovimientoDto;
import org.springframework.core.convert.converter.Converter;

public class MovimientoDtoConverter implements Converter<Movimiento, MovimientoDto> {

    private static MovimientoDtoConverter instance;

    private MovimientoDtoConverter(){}

    public static MovimientoDtoConverter getInstance() {
        return instance == null ? instance = new MovimientoDtoConverter() : instance;
    }

    @Override
    public MovimientoDto convert(Movimiento movimiento) {
        MovimientoDto movimientoDto = new MovimientoDto();
        movimientoDto.setIdGastoComun(movimiento.getGastoComun().getIdGastoComun());
        movimientoDto.setId(movimiento.getId());
        movimientoDto.setFecha(movimiento.getFecha().toString());
        movimientoDto.setMonto(movimiento.getMonto());
        movimientoDto.setTipo(movimiento.getTipo());
        movimientoDto.setIdAsignacion(movimiento.getAsignacion().getIdAsignacion());
        return movimientoDto;
    }
}
