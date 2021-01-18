package com.gi.builmanager.domain.model.property;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyId implements ValueObject<PropertyId> {

    private Integer id;

    @Override
    public boolean sameValueAs(PropertyId another) {
        return false;
    }
}
