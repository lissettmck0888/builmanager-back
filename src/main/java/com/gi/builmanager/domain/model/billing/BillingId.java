package com.gi.builmanager.domain.model.billing;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class BillingId implements ValueObject<BillingId> {

    private Integer id;

    @Override
    public boolean sameValueAs(BillingId another) {
        return false;
    }
}
