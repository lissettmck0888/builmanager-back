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
public class ExpenseItemDetails implements ValueObject<ExpenseItemDetails> {

    private String name;
    private String description;
    private String type;
    //private Boolean active;


    @Override
    public boolean sameValueAs(ExpenseItemDetails another) {
        return false;
    }
}
