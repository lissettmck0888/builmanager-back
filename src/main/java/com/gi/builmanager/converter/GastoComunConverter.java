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

public class GastoComunConverter implements Converter<GastoComunDto, GastoComun> {

    private static GastoComunConverter instance;

    private GastoComunConverter() {}

    public static GastoComunConverter getInstance() {
        return instance == null ? instance = new GastoComunConverter() : instance;
    }

    @Override
    public GastoComun convert(GastoComunDto gastoComunDto) {
        GastoComun gastoComun = new GastoComun();
        gastoComun.setIdGastoComun(gastoComunDto.getIdGastoComun());
        gastoComun.setEstado(gastoComunDto.getEstado());
        gastoComun.setMontoTotal(gastoComunDto.getMontoTotal());
        gastoComun.setPeriodo(gastoComunDto.getPeriodo());
        gastoComun.setListaDetalleGastoComun(listaDetalleGasto(gastoComunDto.getListaDetalleGastoComun(), gastoComun));
        return gastoComun;
    }

    public List<DetalleGastoComun> listaDetalleGasto(List<DetalleGastoComunDto> listDto, GastoComun gastoComun){
        List<DetalleGastoComun> lista = new ArrayList<>();
        for (DetalleGastoComunDto gc : listDto) {
            DetalleGastoComun detalle = new DetalleGastoComun();
            detalle.setGastoComun(gastoComun);
            detalle.setIdDetalleGastoComun(gc.getIdDetalleGastoComun());
            detalle.setMonto(gc.getMonto());
            detalle.setItemGastoComun(toItemGastoComun(gc.getItemGastoComun()));
            lista.add(detalle);
        }
        return lista;
    }

    public ItemGastoComun toItemGastoComun(ItemGastoComunDto itemDto){
        ItemGastoComun item = new ItemGastoComun();
        item.setIdItemGastoComun(itemDto.getIdItemGastoComun());
        item.setNombre(itemDto.getNombre());
        item.setDescripcion(itemDto.getDescripcion());
        item.setTipo(itemDto.getTipo());
        return item;
    }

}
