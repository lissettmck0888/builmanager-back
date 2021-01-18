package com.gi.builmanager.domain.model.expense;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public final class ExpenseDetails implements ValueObject<ExpenseDetails> {

    private String state;
    private Double totalAmount;
    private LocalDate period;
    private List<ExpenseItemValue> expenseItemValues;

    @Override
    public boolean sameValueAs(ExpenseDetails another) {
        return false;
    }
}
