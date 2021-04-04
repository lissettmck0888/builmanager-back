package com.gi.builmanager.application.impl;

import com.gi.builmanager.application.BillingService;
import com.gi.builmanager.domain.model.billing.Transaction;
import com.gi.builmanager.domain.model.billing.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public boolean registerPayment(Transaction transaction) {
        transactionRepository.save(transaction);
        return true;
    }
}
