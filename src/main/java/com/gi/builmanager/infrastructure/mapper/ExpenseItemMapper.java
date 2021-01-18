package com.gi.builmanager.infrastructure.mapper;

import com.gi.builmanager.domain.model.expenseconfig.ExpenseItem;
import com.gi.builmanager.domain.model.expenseconfig.ExpenseItemDetails;
import com.gi.builmanager.domain.model.expenseconfig.ExpenseItemId;
import com.gi.builmanager.infrastructure.hibernate.entity.ItemGastoComun;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ExpenseItemMapper implements RepositoryMapper<ExpenseItem, ItemGastoComun> {

    @Override
    public ExpenseItem fromRepositoryType(ItemGastoComun itemGastoComun) {
        return ExpenseItem.builder()
                .id(ExpenseItemId.builder().id(itemGastoComun.getIdItemGastoComun()).build())
                .details(ExpenseItemDetails.builder()
                        //.active()
                        .type(itemGastoComun.getTipo())
                        .description(itemGastoComun.getDescripcion())
                        .name(itemGastoComun.getNombre())
                        .build())
                .build();
    }

    @Override
    public ItemGastoComun toRepository(ExpenseItem expenseItem) {
        return ItemGastoComun.builder()
                .descripcion(expenseItem.getDetails().getDescription())
                .idItemGastoComun(Objects.nonNull(expenseItem.getId()) ? expenseItem.getId().getId() : null)
                .nombre(expenseItem.getDetails().getName())
                .tipo(expenseItem.getDetails().getType())
                .build();
    }
}
