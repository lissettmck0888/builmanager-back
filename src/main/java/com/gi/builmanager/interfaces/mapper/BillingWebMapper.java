package com.gi.builmanager.interfaces.mapper;

import com.gi.builmanager.domain.model.billing.Billing;
import com.gi.builmanager.interfaces.dto.BillingDto;
import org.springframework.stereotype.Component;

@Component
public class BillingWebMapper {

    public BillingDto toDto(Billing billing) {
        return BillingDto.builder()
                .responsable(billing.getDetails().getGuestFullName())
                //.estado(billing.getDetails().get)
                .apportionFactor(billing.getDetails().getApportionFactor())
                //.fechaPago(billing.getDetails().getPeriod())
                .id(billing.getId().getId())
                .periodDebt(billing.getDetails().getPeriodDebt())
                .previousPeriodDebt(billing.getDetails().getPreviousPeriodDebt())
                .balance(billing.getDetails().getBalance())
                .unidad(billing.getDetails().getMainPropertyIdentifier())
                .idUnidad(billing.getDetails().getMainPropertyId())
                .build();
    }
}
