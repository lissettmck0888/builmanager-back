package com.gi.builmanager.infrastructure.mapper;

import com.gi.builmanager.domain.model.billing.Transaction;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;
import com.gi.builmanager.infrastructure.hibernate.entity.Movimiento;
import com.gi.builmanager.infrastructure.hibernate.entity.Unidad;
import com.gi.builmanager.infrastructure.hibernate.repository.GastoComunRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.UnidadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class TransactionRepositoryManager {

    @Autowired
    private GastoComunRepository gastoComunRepository;
    @Autowired
    private UnidadRepository unidadRepository;

    public TransactionRepositoryHelper newInstance() {
        return new TransactionRepositoryHelper(gastoComunRepository, unidadRepository);
    }

    public static class TransactionRepositoryHelper implements RepositoryMapper.RepositoryHelper<Transaction, Movimiento>{

        final Logger LOGGER = LoggerFactory.getLogger(TransactionRepositoryHelper.class);

        private final Map<Integer, GastoComun> gastoComunMap = new HashMap<>();
        private final Map<Integer, Unidad> unidadMap = new HashMap<>();

        private final GastoComunRepository gastoComunRepository;
        private final UnidadRepository unidadRepository;

        private TransactionRepositoryHelper(GastoComunRepository gastoComunRepository, UnidadRepository unidadRepository) {
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
        public void fillEntity(Transaction transaction, Movimiento movimiento) {
            movimiento.setGastoComun(retrieveGastoComun(transaction.getDetails().getExpenseId()));
            movimiento.setUnidad(retrieveUnidad(transaction.getDetails().getPropertyId()));
        }

        private GastoComun retrieveGastoComun(Integer id) {
            LOGGER.info("retrieveGastoComun...");
            GastoComun gastoComun;
            if (!gastoComunMap.containsKey(id)){
                LOGGER.info("buscando gasto comun en bd...");
                gastoComun = gastoComunRepository.findById(id).orElse(null);
                if (Objects.isNull(gastoComun)){
                    return null;
                }
                gastoComunMap.put(id, gastoComun);
            }
            return gastoComunMap.get(id);
        }

        private Unidad retrieveUnidad(Integer id) {
            LOGGER.info("retrieveUnidad...");
            Unidad unidad;
            if (!unidadMap.containsKey(id)){
                LOGGER.info("buscando unidad en bd...");
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
