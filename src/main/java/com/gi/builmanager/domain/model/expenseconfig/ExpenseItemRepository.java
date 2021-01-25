package com.gi.builmanager.domain.model.expenseconfig;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.ItemGastoComun;

import java.util.List;

public interface ExpenseItemRepository extends BaseRepository<ExpenseItem, ItemGastoComun> {

    List<ExpenseItem> allExtraordinary();
}
