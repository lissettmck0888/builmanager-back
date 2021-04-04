package com.gi.builmanager.application.impl;

import com.gi.builmanager.application.BillingService;
import com.gi.builmanager.domain.model.billing.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BillingRepository billingRepository;

    @Transactional
    @Override
    public boolean registerPayment(Transaction transaction) {
        transactionRepository.save(transaction);
        updatePropertyBilling(transaction);
        return true;
    }

    private void updatePropertyBilling(Transaction transaction) {
        Billing billing = billingRepository.retrieveCurrentPropertyPeriodBilling(transaction.getDetails().getPropertyId());
        billing.setDetails(Billing.afterPayment(billing.getDetails(), transaction));
        billingRepository.save(billing);
    }
}
