package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.shared.BaseRepository;

import java.time.LocalDate;
import java.util.List;

public interface BillingRepository extends BaseRepository<Billing> {

    List<Billing> retrieveCurrentPeriodBilling();
    /*List<Billing> retrieveOpenedExpense();
    List<Billing> retrieveLastClosedExpense();*/
    List<Billing> getBillingByPeriod(LocalDate period);
}
