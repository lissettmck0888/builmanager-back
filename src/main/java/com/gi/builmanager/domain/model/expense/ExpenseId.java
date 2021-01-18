package com.gi.builmanager.domain.model.expense;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExpenseId implements ValueObject<ExpenseId> {

    private Integer id;

    @Override
    public boolean sameValueAs(ExpenseId another) {
        return false;
    }
}
