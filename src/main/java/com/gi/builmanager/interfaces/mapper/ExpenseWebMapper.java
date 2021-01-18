package com.gi.builmanager.interfaces.mapper;

import com.gi.builmanager.domain.model.expense.Expense;
import com.gi.builmanager.domain.model.expense.ExpenseDetails;
import com.gi.builmanager.domain.model.expense.ExpenseId;
import com.gi.builmanager.domain.model.expense.ExpenseItemValue;
import com.gi.builmanager.interfaces.dto.ExpenseDto;
import com.gi.builmanager.interfaces.dto.ExpenseItemValueDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExpenseWebMapper {

    public Expense fromDto(ExpenseDto expenseDto) {

        List<ExpenseItemValue> expenseItemValueList = expenseDto.getExpenseItemList().stream()
                .map(expenseItemValueDto -> ExpenseItemValue.builder()
                        .id(expenseItemValueDto.getId())
                        .name(expenseItemValueDto.getName())
                        .type(expenseItemValueDto.getType())
                        .description(expenseItemValueDto.getDescription())
                        .amount(expenseItemValueDto.getAmount())
                        .build())
                .collect(Collectors.toList());

        return Expense.builder()
                .id(ExpenseId.builder().id(expenseDto.getId()).build())
                .details(ExpenseDetails.builder()
                        .period(expenseDto.getPeriod())
                        .state(expenseDto.getState())
                        .totalAmount(expenseDto.getTotalAmount())
                        .expenseItemValues(expenseItemValueList)
                        .build())
                .build();
    }

    public ExpenseDto toDto(Expense expense) {
        List<ExpenseItemValueDto> expenseItemValueDtoList = expense.getDetails().getExpenseItemValues().stream()
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
                .period(expense.getDetails().getPeriod())
                .state(expense.getDetails().getState())
                .totalAmount(expense.getDetails().getTotalAmount())
                .expenseItemList(expenseItemValueDtoList)
                .build();
    }

}
