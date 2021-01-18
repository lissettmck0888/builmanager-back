package com.gi.builmanager.domain.model.expenseconfig;

import com.gi.builmanager.domain.shared.ValueObject;

public class OrdinaryExpense implements ValueObject<OrdinaryExpense> {

    private Boolean isOrdinaryExpense;

    public void onNew() {
        /*TODO
        * aqui se deberia cargar en tabla plantilla_gastos_ordinarios
        *
        */
    }
    @Override
    public boolean sameValueAs(OrdinaryExpense another) {
        return false;
    }
}
