package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.Abono;
import com.gi.builmanager.dto.AbonoDto;
import org.springframework.core.convert.converter.Converter;

public class AbonoConverter implements Converter<AbonoDto, Abono> {

    private DetalleDeudaUnidadConverter detalleDeudaUnidadConverter = DetalleDeudaUnidadConverter.getInstance();

    @Override
    public Abono convert(AbonoDto abonoDto) {
        Abono abono = new Abono();
        /*abono.setDetalleDeudadUnidad(detalleDeudaUnidadConverter.convert(abonoDto.getDetalleDeudadUnidad()));
        abono.setId(abonoDto.getId());
        abono.setMontoAbono(abonoDto.getMontoAbono());
        abono.setFecha(abonoDto.getFecha());*/
        return abono;
    }
}
