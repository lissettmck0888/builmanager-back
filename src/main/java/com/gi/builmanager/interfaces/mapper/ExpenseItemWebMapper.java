package com.gi.builmanager.interfaces.mapper;

import com.gi.builmanager.domain.model.expenseconfig.ExpenseItem;
import com.gi.builmanager.domain.model.expenseconfig.ExpenseItemDetails;
import com.gi.builmanager.domain.model.expenseconfig.ExpenseItemId;
import com.gi.builmanager.interfaces.dto.ExpenseItemDto;
import org.springframework.stereotype.Component;

@Component
public class ExpenseItemWebMapper {

    public ExpenseItemDto toDto(ExpenseItem expenseItem) {
        return ExpenseItemDto.builder()
                .name(expenseItem.getDetails().getName())
                .description(expenseItem.getDetails().getDescription())
                .type(expenseItem.getDetails().getType())
                //.active(expenseItem.getDetails().getActive())
                .id(expenseItem.getId().getId())
                .build();
    }

    public ExpenseItem toModel(ExpenseItemDto expenseItemDto) {
        return ExpenseItem.builder()
                .id(ExpenseItemId.builder().id(expenseItemDto.getId()).build())
                .details(ExpenseItemDetails.builder()
                        //.active(expenseItemDto.getActive())
                        .name(expenseItemDto.getName())
                        .description(expenseItemDto.getDescription())
                        .type(expenseItemDto.getType())
                        .build())
                //.ordinaryExpense(expenseItemDto.ge)
                .build();
    }
}
