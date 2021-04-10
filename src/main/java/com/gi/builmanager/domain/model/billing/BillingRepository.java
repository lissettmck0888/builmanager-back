package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.EstadoCuenta;
import com.gi.builmanager.infrastructure.mybatis.type.BillingMap;

import java.time.LocalDate;
import java.util.List;

public interface BillingRepository extends BaseRepository<Billing> {

    List<Billing> retrieveCurrentPeriodBilling();
    Billing retrieveCurrentPropertyPeriodBilling(Integer propertyId);
    /*List<Billing> retrieveOpenedExpense();
    List<Billing> retrieveLastClosedExpense();*/
    List<Billing> getBillingByPeriod(LocalDate period);
    List<BillingMap> getBillingByPeriodV2(LocalDate period);
}
