package com.gi.builmanager.interfaces.mapper;

import com.gi.buildman.domain.model.expense.Expense;
import com.gi.builmanager.interfaces.dto.ExpenseDto;
import com.gi.builmanager.interfaces.dto.ExpenseItemValueDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExpenseWebMapper {

    public ExpenseDto toDto(Expense expense) {
        List<ExpenseItemValueDto> expenseItemValueDtoList = expense.getDetails().getExpenseItems().stream()
                .map(expenseItem -> ExpenseItemValueDto.builder()
                        .id(expenseItem.getId())
                        .name(expenseItem.getName())
                        .amount(expenseItem.getAmount())
                        .description(expenseItem.getDescription())
                        .type(expenseItem.getType())
                        .build())
                .collect(Collectors.toList());

        return ExpenseDto.builder()
                .id(expense.getId().getId())
                .expenseItemList(expenseItemValueDtoList)
                .build();
    }

}
