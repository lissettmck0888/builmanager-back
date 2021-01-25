package com.gi.builmanager.infrastructure.mapper;

import com.gi.builmanager.domain.model.billing.Billing;
import com.gi.builmanager.infrastructure.hibernate.entity.EstadoCuenta;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;
import com.gi.builmanager.infrastructure.hibernate.entity.Unidad;
import com.gi.builmanager.infrastructure.hibernate.repository.GastoComunRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class BillingRepositoryManager {

    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Autowired
    private UnidadRepository unidadRepository;

    public BillingRepositoryHelper newInstance() {
        return new BillingRepositoryHelper(gastoComunRepository, unidadRepository);
    }

    public static class BillingRepositoryHelper implements RepositoryMapper.RepositoryHelper<Billing, EstadoCuenta> {

        private final Map<Integer, GastoComun> gastoComunMap = new HashMap<>();
        private final Map<Integer, Unidad> unidadMap = new HashMap<>();

        private GastoComunRepository gastoComunRepository;
        private UnidadRepository unidadRepository;

        private BillingRepositoryHelper(GastoComunRepository gastoComunRepository, UnidadRepository unidadRepository) {
            this.gastoComunRepository = gastoComunRepository;
            this.unidadRepository = unidadRepository;
        }

        @Override
        public void transactionStarted() {

        }

        @Override
        public void transactionFinished() {

        }

        @Override
        public void fillEntity(Billing billing, EstadoCuenta estadoCuenta) {
            estadoCuenta.setGastoComun(retrieveGastoComun(billing.getDetails().getExpenseId()));
            estadoCuenta.setUnidad(retrieveUnidad(billing.getDetails().getMainPropertyId()));
        }

        private GastoComun retrieveGastoComun(Integer id) {
            GastoComun gastoComun;
            if (!gastoComunMap.containsKey(id)){
                gastoComun = gastoComunRepository.findById(id).orElse(null);
                if (Objects.isNull(gastoComun)){
                    return null;
                }
                gastoComunMap.put(id, gastoComun);
            }
            return gastoComunMap.get(id);
        }

        private Unidad retrieveUnidad(Integer id) {
            Unidad unidad;
            if (!unidadMap.containsKey(id)){
                unidad = unidadRepository.findById(id).orElse(null);
                if (Objects.isNull(unidad)){
                    return null;
                }
                unidadMap.put(id, unidad);
            }
            return unidadMap.get(id);
        }
    }

}
