package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionDetails implements ValueObject<TransactionDetails> {

    private Integer propertyId;
    private LocalDateTime date;
    private Double amount;
    private String type;

    @Override
    public boolean sameValueAs(TransactionDetails another) {
        return false;
    }
}
