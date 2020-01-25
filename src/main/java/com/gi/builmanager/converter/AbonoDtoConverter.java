package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.Abono;
import com.gi.builmanager.dto.AbonoDto;
import org.springframework.core.convert.converter.Converter;

public class AbonoDtoConverter implements Converter<Abono, AbonoDto> {

    private DetalleDeudaUnidadDtoConverter detalleDeudaUnidadDtoConverter = DetalleDeudaUnidadDtoConverter.getInstance();

    @Override
    public AbonoDto convert(Abono abono) {
        AbonoDto dto = new AbonoDto();
        dto.setDetalleDeudadUnidad(detalleDeudaUnidadDtoConverter.convert(abono.getDetalleDeudadUnidad()));
        dto.setFecha(abono.getFecha());
        dto.setId(abono.getId());
        dto.setMontoAbono(abono.getMontoAbono());
        return dto;
    }
}
