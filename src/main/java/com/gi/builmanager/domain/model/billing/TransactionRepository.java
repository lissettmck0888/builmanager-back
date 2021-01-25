package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.Movimiento;

import java.util.List;

public interface TransactionRepository extends BaseRepository<Transaction, Movimiento> {

    List<Transaction> retrieveClosedPeriodPaymentsList();
}
