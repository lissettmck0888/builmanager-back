package com.gi.builmanager.domain.model.expense;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;

import java.util.List;

public interface ExpenseRepository extends BaseRepository<Expense> {

    Expense retrieveCurrentExpense();
    Expense retrieveOpenedExpense();
    Expense retrieveLastClosedExpense();
    List<ExpenseItemValue> retrieveOrdinaryExpenses();


}
