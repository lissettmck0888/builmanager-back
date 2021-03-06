package com.gi.builmanager.infrastructure;

import com.gi.builmanager.domain.model.billing.Transaction;
import com.gi.builmanager.domain.model.billing.TransactionRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;
import com.gi.builmanager.infrastructure.hibernate.repository.GastoComunRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.MovimientoRepository;
import com.gi.builmanager.infrastructure.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class TransactionPrimaryRepository implements TransactionRepository {

    @Autowired
    TransactionMapper transactionMapper;

    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private GastoComunRepository gastoComunRepository;

    @Override
    public List<Transaction> retrieveClosedPeriodPaymentsList() {
        GastoComun last = gastoComunRepository.findUltimoGastoComunCerrado().orElse(null);
        if (Objects.nonNull(last)){
            return movimientoRepository.findByGastoComunAndTipo(last, "Abono").stream()
                    .map(movimiento -> transactionMapper.fromRepositoryType(movimiento))
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public Transaction getById(Integer id) {
        return null;
    }

    @Override
    public Integer save(Transaction transaction) {
        movimientoRepository.save(transactionMapper.toRepository(transaction));
        return 1;
    }

    @Override
    public Integer saveAll(List<Transaction> transactionList) {
        movimientoRepository.saveAll(transactionList.stream()
                .map(transaction -> transactionMapper.toRepository(transaction))
                .collect(Collectors.toList())
        );
        return 1;
    }
}
