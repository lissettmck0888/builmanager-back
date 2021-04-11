package com.gi.builmanager.infrastructure.hibernate.mapper.helper;

import com.gi.builmanager.domain.model.billing.Transaction;
import com.gi.builmanager.domain.shared.RepositoryHelper;
import com.gi.builmanager.infrastructure.hibernate.entity.Movimiento;
import com.gi.builmanager.infrastructure.hibernate.entity.Unidad;
import com.gi.builmanager.infrastructure.hibernate.repository.UnidadRepository;

public class UnidadEntityHelper extends RepositoryHelper</*Movimiento, */Unidad, Integer> {

    private UnidadRepository unidadRepository;

    public UnidadEntityHelper(UnidadRepository unidadRepository, SourceId<Integer> sourceId, Action<Unidad> action) {
        super(sourceId, action);
        this.unidadRepository = unidadRepository;
    }

    @Override
    public Unidad retrieveObject(Integer id) {
        return unidadRepository.findById(id).orElse(null);
    }

    /*@Override
    public Integer retrieveId(Transaction entity) {
        return entity.getDetails().getPropertyId();
    }*/

    /*@Override
    public void performAction(Unidad unidad, Movimiento movimiento) {
        movimiento.setUnidad(unidad);
    }*/
}
