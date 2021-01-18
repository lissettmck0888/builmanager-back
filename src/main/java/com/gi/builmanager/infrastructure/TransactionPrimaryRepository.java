package com.gi.builmanager.infrastructure;

import com.gi.builmanager.domain.model.billing.Transaction;
import com.gi.builmanager.domain.model.billing.TransactionRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionPrimaryRepository implements TransactionRepository {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public List<Transaction> retrieveClosedPeriodPaymentsList() {
        return null;
    }
}
