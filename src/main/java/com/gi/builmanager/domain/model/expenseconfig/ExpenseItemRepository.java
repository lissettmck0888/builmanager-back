package com.gi.builmanager.domain.model.expenseconfig;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.ItemGastoComun;

import java.util.List;

public abstract class ExpenseItemRepository extends BaseRepository<ExpenseItem> {

    public abstract List<ExpenseItem> allExtraordinary();
}
