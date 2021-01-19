package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.EstadoCuenta;
import com.gi.builmanager.dto.EstadoCuentaDto;
import org.springframework.core.convert.converter.Converter;


public class EstadoCuentaConverter implements Converter<EstadoCuenta, EstadoCuentaDto> {

    private final GastoComunDtoConverter gastoComunDtoConverter = GastoComunDtoConverter.getInstance();
    private final UnidadDtoConverter unidadDtoConverter = UnidadDtoConverter.getInstance();

    @Override
    public EstadoCuentaDto convert(EstadoCuenta estadoCuenta){
        EstadoCuentaDto estadoCuentaDto = new EstadoCuentaDto();
        estadoCuentaDto.setId(estadoCuenta.getId());
        estadoCuentaDto.setGastoComun(gastoComunDtoConverter.convert(estadoCuenta.getGastoComun()));
        estadoCuentaDto.setMontoTotal(estadoCuenta.getSaldo());
        estadoCuentaDto.setMonto(estadoCuenta.getDeudaInicial());
        estadoCuentaDto.setFactorProrrateo(estadoCuenta.getFactorProrrateo());
        estadoCuentaDto.setMontoAnterior(estadoCuenta.getMontoAnterior());
        //estadoCuentaDto.setResponsable(estadoCuenta.get);
        estadoCuentaDto.setUnidad(unidadDtoConverter.convert(estadoCuenta.getUnidad()));
        return estadoCuentaDto;
    }
}
