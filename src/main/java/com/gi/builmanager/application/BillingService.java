package com.gi.builmanager.application;

import com.gi.builmanager.domain.model.billing.Transaction;

public interface BillingService {

    boolean registerPayment(Transaction transaction);
}
