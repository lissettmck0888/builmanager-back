package com.gi.builmanager.interfaces.mapper;

import com.gi.builmanager.domain.model.expense.Expense;
import com.gi.builmanager.interfaces.dto.ExpensePeriodDto;
import org.springframework.stereotype.Component;

@Component
public class ExpensePeriodWebMapper {

    public ExpensePeriodDto toDto(Expense expense) {
        return ExpensePeriodDto.builder()
                .id(expense.getId().getId())
                .period(expense.getDetails().getPeriod())
                .totalAmount(expense.getDetails().getTotalAmount())
                .build();
    }
}
