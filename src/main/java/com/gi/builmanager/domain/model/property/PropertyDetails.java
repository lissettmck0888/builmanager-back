package com.gi.builmanager.domain.model.property;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropertyDetails {

    private String type;
    private String description;
    private Integer floor;
    private String number;
    private String sector;
    private Double squareMeters;
    private Boolean apportionmentMark;

}
