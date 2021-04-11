package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.EstadoCuenta;
import com.gi.builmanager.infrastructure.mybatis.type.BillingMap;

import java.time.LocalDate;
import java.util.List;

public abstract class BillingRepository extends BaseRepository<Billing> {

    public abstract List<Billing> retrieveCurrentPeriodBilling();
    public abstract Billing retrieveCurrentPropertyPeriodBilling(Integer propertyId);
    /*List<Billing> retrieveOpenedExpense();
    List<Billing> retrieveLastClosedExpense();*/
    public abstract List<Billing> getBillingByPeriod(LocalDate period);
    public abstract List<BillingMap> getBillingByPeriodV2(LocalDate period);
}
