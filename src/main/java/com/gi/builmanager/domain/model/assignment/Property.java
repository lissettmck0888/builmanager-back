package com.gi.builmanager.domain.model.assignment;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Property implements ValueObject<Property> {

    private Integer id;
    private String type;
    private String description;
    private Integer floor;
    private String number;
    private String sector;
    private Double squareMeters;
    private Boolean apportionmentMark;
    private Boolean mainProperty; //unidadCopropiedad

    @Override
    public boolean sameValueAs(Property another) {
        return false;
    }
}
