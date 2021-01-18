package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.shared.AggregateRoot;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction extends AggregateRoot<Transaction> {

    //Movimiento
    private TransactionId id;
    private TransactionDetails details;

    @Override
    public boolean sameEntityAs(Transaction another) {
        return false;
    }
}
