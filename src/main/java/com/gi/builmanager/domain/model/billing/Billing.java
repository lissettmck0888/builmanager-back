package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.model.assignment.Property;
import com.gi.builmanager.domain.model.expense.Expense;
import com.gi.builmanager.domain.shared.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class Billing extends AggregateRoot<Billing> {

    //Estado Cuenta
    private BillingId id;
    private BillingDetails details;

    private Billing() {}

    public static Billing from(Expense currentExpense, Property property, Double apportionFactor,
                               Double lastPeriodBillingAmount, Double lastPeriodTotalPayments) {

        Billing billing = new Billing();

        List<Transaction> transactionList = new ArrayList<>();
        Transaction periodTransaction = generatePeriodTransaction(property, currentExpense, apportionFactor);
        transactionList.add(periodTransaction);

        //FIXME podrian ser multiples transacciones (cuenta del mes, multas, intereses, etc)
        Double balance = lastPeriodBillingAmount + periodTransaction.getDetails().getAmount();

        BillingDetails details = BillingDetails.builder()
                .mainPropertyId(property.getId())
                .mainPropertyIdentifier(property.getNumber())
                //.guestFullName(guestFullName)
                .expenseId(currentExpense.getId().getId())
                .apportionFactor(apportionFactor)
                .period(LocalDate.now())
                .previousPeriodDebt(lastPeriodBillingAmount)
                .periodDebt(periodTransaction.getDetails().getAmount())//FIXME podrian ser multiples transacciones (cuenta del mes, multas, intereses, etc)
                .periodTotalDebt(balance)
                .balance(balance)
                .transactionList(transactionList)
           .build();

        billing.setDetails(details);

        return billing;
    }

    private static Transaction generatePeriodTransaction(Property property, Expense currentExpense, Double apportionFactor) {
        return Transaction.builder()
                .details(TransactionDetails.builder()
                        .propertyId(property.getId())
                        .expenseId(currentExpense.getId().getId())
                        .date(LocalDateTime.now())
                        .type("Cargo")
                        .amount(round(currentExpense.getDetails().getTotalAmount() * apportionFactor, 0))
                        .build())
                .build();
    }

    public static BillingDetails afterPayment(BillingDetails billingDetails, Transaction transaction) {
        billingDetails.setPayment((Objects.nonNull(billingDetails.getPayment())? billingDetails.getPayment():0)  + transaction.getDetails().getAmount());
        billingDetails.setBalance(billingDetails.getPeriodDebt() + billingDetails.getPreviousPeriodDebt() - billingDetails.getPayment());
        return billingDetails;
    }

    private static void generateExtraPeriodCharges() {
        //TODO: aca se deberian determinar cobros extras
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public boolean sameEntityAs(Billing another) {
        return false;
    }
}
