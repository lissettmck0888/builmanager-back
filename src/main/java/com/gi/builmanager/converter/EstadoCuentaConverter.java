package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.EstadoCuenta;
import com.gi.builmanager.dto.EstadoCuentaDto;
import org.springframework.core.convert.converter.Converter;


public class EstadoCuentaConverter implements Converter<EstadoCuenta, EstadoCuentaDto> {

    @Override
    public EstadoCuentaDto convert(EstadoCuenta estadoCuenta){
        EstadoCuentaDto estadoCuentaDto = new EstadoCuentaDto();
        estadoCuentaDto.setId(estadoCuenta.getId());
        estadoCuentaDto.setGastoComun(estadoCuenta.getGastoComun().getIdGastoComun());
        estadoCuentaDto.setSaldo(estadoCuenta.getSaldo());
        estadoCuentaDto.setUnidad(estadoCuenta.getUnidad());
        return estadoCuentaDto;
    }
}
