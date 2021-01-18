package com.gi.builmanager.interfaces.mapper;

import com.gi.builmanager.domain.model.property.Property;
import com.gi.builmanager.interfaces.dto.PropertyDto;
import org.springframework.stereotype.Component;

@Component
public class PropertyWebMapper {

    public PropertyDto toDto(Property property) {
        return PropertyDto.builder()
                .mainProperty(property.getMainProperty())
                .id(property.getId().getId())
                .sector(property.getDetails().getSector())
                .description(property.getDetails().getDescription())
                .number(property.getDetails().getNumber())
                .floor(property.getDetails().getFloor())
                .type(property.getDetails().getType())
                .requiresApportion(property.getDetails().getApportionmentMark())
                .squareMeters(property.getDetails().getSquareMeters())
                .build();
    }
}
