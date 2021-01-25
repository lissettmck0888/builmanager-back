package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.EstadoCuenta;

import java.time.LocalDate;
import java.util.List;

public interface BillingRepository extends BaseRepository<Billing, EstadoCuenta> {

    List<Billing> retrieveCurrentPeriodBilling();
    /*List<Billing> retrieveOpenedExpense();
    List<Billing> retrieveLastClosedExpense();*/
    List<Billing> getBillingByPeriod(LocalDate period);
}
