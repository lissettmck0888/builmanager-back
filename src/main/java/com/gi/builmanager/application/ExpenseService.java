package com.gi.builmanager.application;

import com.gi.builmanager.domain.model.expense.Expense;

public interface ExpenseService {

    void updateExpense(Expense expense);
    void terminateOpenedExpense();
    void generateDebt();
}

