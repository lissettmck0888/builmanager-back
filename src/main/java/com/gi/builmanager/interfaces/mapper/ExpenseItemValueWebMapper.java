package com.gi.builmanager.interfaces.mapper;

import com.gi.buildman.domain.model.expense.ExpenseItem;
import com.gi.builmanager.interfaces.dto.ExpenseItemValueDto;
import org.springframework.stereotype.Component;

@Component
public class ExpenseItemValueWebMapper {

    public ExpenseItemValueDto toDto(ExpenseItem expenseItem) {
        return null;
    }

    public ExpenseItem toModel(ExpenseItemValueDto expenseItemDto) {
        return null;
    }

}
