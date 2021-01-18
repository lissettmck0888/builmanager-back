package com.gi.builmanager.interfaces.mapper;

import com.gi.builmanager.domain.model.expense.ExpenseItemValue;
import com.gi.builmanager.interfaces.dto.ExpenseItemValueDto;
import org.springframework.stereotype.Component;

@Component
public class ExpenseItemValueWebMapper {

    public ExpenseItemValueDto toDto(ExpenseItemValue expenseItemValue) {
        return ExpenseItemValueDto.builder()
                .id(expenseItemValue.getId())
                .name(expenseItemValue.getName())
                .description(expenseItemValue.getDescription())
                .amount(expenseItemValue.getAmount())
                .type(expenseItemValue.getType())
                .build();
    }

    public ExpenseItemValue toModel(ExpenseItemValueDto expenseItemDto) {
        return ExpenseItemValue.builder()
                .id(expenseItemDto.getId())
                .name(expenseItemDto.getName())
                .description(expenseItemDto.getDescription())
                .amount(expenseItemDto.getAmount())
                .type(expenseItemDto.getType())
                .build();
    }

}
