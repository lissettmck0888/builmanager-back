package com.gi.builmanager.domain.model.expenseconfig;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseItemId implements ValueObject<ExpenseItemId> {

    private Integer id;

    @Override
    public boolean sameValueAs(ExpenseItemId another) {
        return false;
    }
}
