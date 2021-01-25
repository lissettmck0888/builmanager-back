package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.shared.BaseRepository;

import java.util.List;

public interface TransactionRepository extends BaseRepository<Transaction> {

    List<Transaction> retrieveClosedPeriodPaymentsList();
}
