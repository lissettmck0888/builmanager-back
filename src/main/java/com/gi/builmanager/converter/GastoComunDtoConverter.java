package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.DetalleGastoComun;
import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.dominio.ItemGastoComun;
import com.gi.builmanager.dto.DetalleGastoComunDto;
import com.gi.builmanager.dto.GastoComunDto;
import com.gi.builmanager.dto.ItemGastoComunDto;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class GastoComunDtoConverter implements Converter<GastoComun, GastoComunDto> {
    @Override
    public GastoComunDto convert(GastoComun gastoComun) {
        GastoComunDto gastoComunDto = new GastoComunDto();
        gastoComunDto.setIdGastoComun(gastoComun.getIdGastoComun());
        gastoComunDto.setEstado(gastoComun.getEstado());
        gastoComunDto.setMontoTotal(gastoComun.getMontoTotal());
        gastoComunDto.setPeriodo(gastoComun.getPeriodo());
        gastoComunDto.setListaDetalleGastoComun(listaDetalleGastoDto(gastoComun.getListaDetalleGastoComun()));
        return gastoComunDto;
    }

    public List<DetalleGastoComunDto> listaDetalleGastoDto(List<DetalleGastoComun> list){
        List<DetalleGastoComunDto> listaDto = new ArrayList<>();
        for (DetalleGastoComun gc : list) {
            DetalleGastoComunDto dto = new DetalleGastoComunDto();
            dto.setIdDetalleGastoComun(gc.getIdDetalleGastoComun());
            dto.setMonto(gc.getMonto());
            dto.setItemGastoComun(toItemGastoComunDto(gc.getItemGastoComun()));
            listaDto.add(dto);
        }
        return listaDto;
    }

    public ItemGastoComunDto toItemGastoComunDto(ItemGastoComun item){
        ItemGastoComunDto igcdto = new ItemGastoComunDto();
        igcdto.setIdItemGastoComun(item.getIdItemGastoComun());
        igcdto.setNombre(item.getNombre());
        igcdto.setDescripcion(item.getDescripcion());
        return  igcdto;
    }

}
