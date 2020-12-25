package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.Movimiento;
import com.gi.builmanager.dto.MovimientoDto;
import org.springframework.core.convert.converter.Converter;

public class MovimientoDtoConverter implements Converter<Movimiento, MovimientoDto> {
    @Override
    public MovimientoDto convert(Movimiento movimiento) {
        MovimientoDto movimientoDto = new MovimientoDto();
        movimientoDto.setIdGastoComun(movimiento.getId());
        movimientoDto.setId(movimiento.getId());
        movimientoDto.setFecha(movimiento.getFecha().toString());
        movimientoDto.setMonto(movimiento.getMonto());
        movimientoDto.setTipo(movimiento.getTipo());
        movimientoDto.setIdUnidad(movimiento.getUnidad().getIdUnidad());
        return movimientoDto;
    }
}
