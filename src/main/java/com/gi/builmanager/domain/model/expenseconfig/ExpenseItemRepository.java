package com.gi.builmanager.domain.model.expenseconfig;

import com.gi.builmanager.domain.shared.BaseRepository;

import java.util.List;

public interface ExpenseItemRepository extends BaseRepository<ExpenseItem> {

    List<ExpenseItem> allExtraordinary();
}
