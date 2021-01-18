package com.gi.builmanager.domain.model.expenseconfig;

import com.gi.builmanager.domain.shared.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseItem extends AggregateRoot<ExpenseItem> {

    private ExpenseItemId id;
    private ExpenseItemDetails details;
    private OrdinaryExpense ordinaryExpense;

    @Override
    public boolean sameEntityAs(ExpenseItem another) {
        return false;
    }
}
