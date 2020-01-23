package com.gi.builmanager.service.impl;

import com.gi.builmanager.constants.EstadoGastoComunEnum;
import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.dominio.ItemGastoComun;
import com.gi.builmanager.dominio.PlantillaGastosOrdinarios;
import com.gi.builmanager.repositorio.GastoComunRepository;
import com.gi.builmanager.repositorio.ItemGastoComunRepository;
import com.gi.builmanager.repositorio.PlantillaGastosOrdinariosRepository;
import com.gi.builmanager.repositorio.UnidadRepository;
import com.gi.builmanager.repositorio.projection.GastoComunView;
import com.gi.builmanager.service.GastoComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GastoComunServiceImpl implements GastoComunService {

    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Autowired
    private ItemGastoComunRepository itemGastoComunRepository;
    @Autowired
    private PlantillaGastosOrdinariosRepository plantillaGastosOrdinariosRepository;
    @Autowired
    private UnidadRepository unidadRepository;

    @Override
    public GastoComun actualizar(GastoComun gastoComun) {
        gastoComun.getListaDetalleGastoComun().stream().forEach(detalleGastoComun -> {
            if(detalleGastoComun.getItemGastoComun().getIdItemGastoComun() == null ||
                    detalleGastoComun.getItemGastoComun().getIdItemGastoComun() == 0){
                ItemGastoComun item = itemGastoComunRepository.save(detalleGastoComun.getItemGastoComun());
                detalleGastoComun.setItemGastoComun(item);
            }
        });
        return gastoComunRepository.save(gastoComun);
    }

    @Override
    public GastoComun getGastoComunAbierto() {
        return gastoComunRepository.findByEstado(EstadoGastoComunEnum.OPENED.nombre);
    }

    @Override
    public List<GastoComun> getGastoComun() {
        return gastoComunRepository.findAll();
    }

    @Override
    public GastoComun cerrarGastoComunPeriodo() {
        return null;
    }

    @Override
    public ItemGastoComun guardarItem(ItemGastoComun itemGastoComun) {
        return itemGastoComunRepository.save(itemGastoComun);
    }

    @Override
    public List<ItemGastoComun> getItems() {
        return itemGastoComunRepository.findAll();
    }

    @Override
    public List<PlantillaGastosOrdinarios> getPlantillaGastosOrdinarios() {
        return plantillaGastosOrdinariosRepository.findByActivoEqualsTrue();
    }


}
