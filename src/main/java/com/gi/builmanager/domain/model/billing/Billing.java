package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.model.assignment.Property;
import com.gi.builmanager.domain.model.expense.Expense;
import com.gi.builmanager.domain.model.guest.Guest;
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
        Transaction periodTransaction = Transaction.builder().build();
        generatePeriodTransactionDetails(periodTransaction, currentExpense, apportionFactor);
        transactionList.add(periodTransaction);


        //FIXME podrian ser multiples transacciones (cuenta del mes, multas, intereses, etc)
        Double balance = lastPeriodBillingAmount + periodTransaction.getDetails().getAmount() - lastPeriodTotalPayments;

        BillingDetails details = BillingDetails.builder()
                .mainPropertyId(property.getId())
                .mainPropertyIdentifier(property.getNumber())
                .guestFullName(guestFullName)
                .expenseId(currentExpense.getId().getId())
                .apportionFactor(apportionFactor)
                .period(LocalDate.now())
                .previousPeriodDebt(lastPeriodBillingAmount - lastPeriodTotalPayments)
                .periodDebt(periodTransaction.getDetails().getAmount())//FIXME podrian ser multiples transacciones (cuenta del mes, multas, intereses, etc)
                .balance(balance)
                .transactionList(transactionList)
           .build();

        billing.setDetails(details);

        return billing;
    }

    private static void generatePeriodTransactionDetails(Transaction transaction, Expense currentExpense, Double apportionFactor) {
        transaction.setDetails(
                TransactionDetails.builder()
                        .date(LocalDateTime.now())
                        .type("Cargo")
                        .amount(round(currentExpense.getDetails().getTotalAmount() * apportionFactor, 0))
                .build()
        );
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
