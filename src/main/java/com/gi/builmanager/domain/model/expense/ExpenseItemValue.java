package com.gi.builmanager.domain.model.expense;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExpenseItemValue implements ValueObject<ExpenseItemValue> {

    private Integer id;
    private Double amount;
    private String name;
    private String description;
    private String type;

    @Override
    public boolean sameValueAs(ExpenseItemValue another) {
        return false;
    }
}
