package com.gi.builmanager.domain.model.billing;

import java.util.List;

public interface TransactionRepository {

    List<Transaction> retrieveClosedPeriodPaymentsList();
}
