package com.gi.builmanager.domain.model.property;

import com.gi.builmanager.domain.shared.AggregateRoot;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Property extends AggregateRoot<Property> {

    private PropertyId id;
    private PropertyDetails details;
    private Boolean mainProperty; //unidadCopropiedad

    @Override
    public boolean sameEntityAs(Property another) {
        return false;
    }
}
