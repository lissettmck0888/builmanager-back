package com.gi.builmanager.domain.model.expense;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;

import java.util.List;

public abstract class ExpenseRepository extends BaseRepository<Expense> {

    public abstract Expense retrieveCurrentExpense();
    public abstract Expense retrieveOpenedExpense();
    public abstract Expense retrieveLastClosedExpense();
    public abstract List<ExpenseItemValue> retrieveOrdinaryExpenses();


}
