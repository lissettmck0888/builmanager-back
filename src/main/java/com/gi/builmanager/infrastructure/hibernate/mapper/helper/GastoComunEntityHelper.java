package com.gi.builmanager.infrastructure.hibernate.mapper.helper;

import com.gi.builmanager.domain.shared.RepositoryHelper;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;
import com.gi.builmanager.infrastructure.hibernate.entity.Movimiento;
import com.gi.builmanager.infrastructure.hibernate.repository.GastoComunRepository;

public class GastoComunEntityHelper extends RepositoryHelper</*Movimiento, */GastoComun, Integer> {

    private GastoComunRepository gastoComunRepository;

    public GastoComunEntityHelper(GastoComunRepository gastoComunRepository, SourceId<Integer> sourceId, Action<GastoComun> action) {
        super(sourceId, action);
        this.gastoComunRepository = gastoComunRepository;
    }

    @Override
    public GastoComun retrieveObject(Integer id) {
        return gastoComunRepository.findById(id).orElse(null);
    }

    /*@Override
    public void performAction(GastoComun source, Movimiento target) {
        target.setGastoComun(source);
    }*/

}
