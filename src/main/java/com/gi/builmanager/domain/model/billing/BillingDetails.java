package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class BillingDetails implements ValueObject<BillingDetails> {

    //private GastoComun gastoComun;
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
    private List<Transaction> transactionList;

    @Override
    public boolean sameValueAs(BillingDetails another) {
        return false;
    }
}
