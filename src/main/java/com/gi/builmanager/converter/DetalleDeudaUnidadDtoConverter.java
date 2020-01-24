package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.DetalleDeudadUnidad;
import com.gi.builmanager.dto.DetalleDeudaUnidadDto;
import org.springframework.core.convert.converter.Converter;

public class DetalleDeudaUnidadDtoConverter implements Converter<DetalleDeudadUnidad, DetalleDeudaUnidadDto> {

    GastoComunDtoConverter gastoComunDtoConverter = GastoComunDtoConverter.getInstance();
    UnidadDtoConverter unidadDtoConverter = UnidadDtoConverter.getInstance();

    @Override
    public DetalleDeudaUnidadDto convert(DetalleDeudadUnidad detalleDeudadUnidad) {
        DetalleDeudaUnidadDto dto = new DetalleDeudaUnidadDto();
        dto.setResponsable(detalleDeudadUnidad.getResponsable());
        dto.setEstado(detalleDeudadUnidad.getEstado());
        dto.setFactorProrrateo(detalleDeudadUnidad.getFactorProrrateo());
        dto.setFechaPago(detalleDeudadUnidad.getFechaPago());
        dto.setGastoComun(gastoComunDtoConverter.convert(detalleDeudadUnidad.getGastoComun()));
        dto.setIdDetalleDeudaUnidad(detalleDeudadUnidad.getIdDetalleDeudaUnidad());
        dto.setMontoAnterior(detalleDeudadUnidad.getMontoAnterior());
        dto.setMonto(detalleDeudadUnidad.getMonto());
        dto.setMontoTotal(detalleDeudadUnidad.getTotal());
        dto.setUnidad(unidadDtoConverter.convert(detalleDeudadUnidad.getUnidad()));
        dto.setIdDetalleDeudaUnidad(detalleDeudadUnidad.getIdDetalleDeudaUnidad());
        return dto;
    }


}
