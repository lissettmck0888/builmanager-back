package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionId implements ValueObject<TransactionId> {

    private Integer id;

    @Override
    public boolean sameValueAs(TransactionId another) {
        return false;
    }
}
