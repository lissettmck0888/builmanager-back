package com.gi.builmanager.application.impl;

import com.gi.builmanager.application.BillingService;
import com.gi.builmanager.domain.model.billing.Billing;
import com.gi.builmanager.domain.model.billing.BillingRepository;
import com.gi.builmanager.domain.model.billing.Transaction;
import com.gi.builmanager.domain.model.billing.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.gi.builmanager.domain.model.billing.Billing.afterPayment;

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
        billing.setDetails(afterPayment(billing.getDetails(), transaction));
        billingRepository.save(billing);
    }
}
