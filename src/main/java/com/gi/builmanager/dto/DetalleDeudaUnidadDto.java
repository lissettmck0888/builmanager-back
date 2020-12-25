package com.gi.builmanager.dto;

import com.gi.builmanager.converter.GastoComunDtoConverter;
import com.gi.builmanager.converter.UnidadDtoConverter;
import com.gi.builmanager.dominio.EstadoCuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetalleDeudaUnidadDto {

    private Integer idDetalleDeudaUnidad;
    private String responsable;
    private Double monto;
    private Double montoAnterior;
    private Double montoTotal;
    private Double factorProrrateo;
    private String estado;
    private LocalDate fechaPago;
    private UnidadDto unidad;
    private GastoComunDto gastoComun;

    public static DetalleDeudaUnidadDto of(EstadoCuenta estadoCuenta) {
        return DetalleDeudaUnidadDto.builder()
                .estado("")
                .factorProrrateo(estadoCuenta.getFactorProrrateo())
                .gastoComun(GastoComunDtoConverter.getInstance().convert(estadoCuenta.getGastoComun()))
                .monto(estadoCuenta.getDeudaInicial())
                .montoAnterior(estadoCuenta.getMontoAnterior())
                .montoTotal(estadoCuenta.getSaldo())
                .unidad(UnidadDtoConverter.getInstance().convert(estadoCuenta.getUnidad()))
                //.responsable(estadoCuenta.getUnidad().get)
            .build();
    }
}
