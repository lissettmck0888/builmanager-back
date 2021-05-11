package com.gi.builmanager.dto;

import com.gi.builmanager.converter.AsignacionDtoConverter;
import com.gi.builmanager.converter.GastoComunDtoConverter;
import com.gi.builmanager.converter.UnidadDtoConverter;
import com.gi.builmanager.dominio.Asignacion;
import com.gi.builmanager.dominio.EstadoCuenta;
import com.gi.builmanager.dominio.Persona;
import com.gi.builmanager.dominio.Unidad;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoCuentaDto {

    private Integer id;
    private String responsable;
    private Double monto;
    private Double montoAnterior;
    private Double montoTotal;
    private Double abonos;
    private Double saldo;
    private Double factorProrrateo;
    private String estado;
    private LocalDate fechaPago;
    private String unidad;
    private Integer idUnidad;
    private Integer idAsignacion;
    private GastoComunDto gastoComun;

    public static EstadoCuentaDto of(EstadoCuenta estadoCuenta) {
        Unidad unidad = extaerUnidadPrincipal(estadoCuenta.getAsignacion());
        return EstadoCuentaDto.builder()
                .estado("")
                .factorProrrateo(estadoCuenta.getFactorProrrateo())
                .gastoComun(GastoComunDtoConverter.getInstance().convert(estadoCuenta.getGastoComun()))
                .monto(estadoCuenta.getMontoInicial())
                .montoAnterior(estadoCuenta.getMontoAnterior())
                .montoTotal(estadoCuenta.getSaldo())
                //.unidad(UnidadDtoConverter.getInstance().convert(estadoCuenta.getUnidad()))
                //.asignacionDto(AsignacionDtoConverter.getInstance().convert(estadoCuenta.getAsignacion()))
                .responsable(extraerNombre(estadoCuenta.getAsignacion().getPersona()))
                .unidad(unidad.getNumero())
                .idUnidad(unidad.getIdUnidad())
                .abonos(estadoCuenta.getAbonos())
                .saldo(estadoCuenta.getSaldo())
                .idAsignacion(estadoCuenta.getAsignacion().getIdAsignacion())
                .build();
    }

    private static Unidad extaerUnidadPrincipal(Asignacion asignacion) {
        return asignacion.getUnidades().stream()
                .filter(Unidad::getEsUnidadCopropiedad)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static String extraerNombre(Persona persona) {
        return String.format("%s %s %s", persona.getNombres(), persona.getApellidoPaterno(), persona.getApellidoMaterno());
    }
}
