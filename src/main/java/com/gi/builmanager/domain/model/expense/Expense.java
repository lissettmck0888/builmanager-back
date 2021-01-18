package com.gi.builmanager.domain.model.expense;

import com.gi.builmanager.domain.shared.AggregateRoot;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Expense extends AggregateRoot<Expense> {

    private ExpenseId id;
    private ExpenseDetails details;

    public static Expense newExpense(LocalDate current) {
        return Expense.builder()
                .details(ExpenseDetails.builder()
                        .period(current.plusMonths(1))
                        .state("Abierto")
                        .expenseItemValues(new ArrayList<>())
                    .build()
                )
            .build();
    }

    public void closeExpense() {
        details = ExpenseDetails.builder()
                .expenseItemValues(details.getExpenseItemValues())
                .period(details.getPeriod())
                .totalAmount(details.getTotalAmount())
                .state("Cerrado")
        .build();
    }

    public void terminateExpensePeriod(List<ExpenseItemValue> ordinaryExpenses) {
        List<ExpenseItemValue> expenseItemValues = details.getExpenseItemValues();
        expenseItemValues.addAll(ordinaryExpenses);
        Double total = expenseItemValues
                .stream().map(ExpenseItemValue::getAmount).reduce(0D, Double::sum);

        details = ExpenseDetails.builder()
                .expenseItemValues(expenseItemValues)
                .period(details.getPeriod())
                .totalAmount(total)
                .state("Actual")
        .build();
    }

    public void updateExpenseItemList(List<ExpenseItemValue> expenseItemValueList) {
        //todo

    }

    @Override
    public boolean sameEntityAs(Expense another) {
        return false;
    }
}
