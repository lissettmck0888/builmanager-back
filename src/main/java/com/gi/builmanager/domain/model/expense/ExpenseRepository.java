package com.gi.builmanager.domain.model.expense;

import com.gi.builmanager.domain.shared.BaseRepository;

import java.util.List;

public interface ExpenseRepository extends BaseRepository<Expense> {

    Expense retrieveCurrentExpense();
    Expense retrieveOpenedExpense();
    Expense retrieveLastClosedExpense();
    List<ExpenseItemValue> retrieveOrdinaryExpenses();


}
