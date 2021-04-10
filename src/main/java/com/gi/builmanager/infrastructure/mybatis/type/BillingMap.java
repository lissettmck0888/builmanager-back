package com.gi.builmanager.infrastructure.mybatis.type;

import com.gi.builmanager.domain.model.billing.Billing;
import com.gi.builmanager.domain.model.billing.BillingDetails;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BillingMap {

    private Integer id;
    private LocalDate period;
    private Integer expenseId;
    private Integer mainPropertyId;
    private String mainPropertyIdentifier;
    private String guestFullName;
    private Double apportionFactor;//factor prorrateo
    private Double previousPeriodDebt;//deuda anterior
    private Double periodDebt;//deuda
    private Double periodTotalDebt;//deudaTotal
    private Double payment;//abono
    private Double balance;//saldo
    private List<TransactionMap> transactions;

    public static class DomainMapper {

        public Billing toDomain(BillingMap billingMap) {
            return Billing.builder()
                    .details(BillingDetails.builder()
                            .build())
                    .build();
        }
    }
}
