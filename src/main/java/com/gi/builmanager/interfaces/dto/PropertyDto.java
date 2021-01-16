package com.gi.builmanager.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto implements Serializable {

    private static final long serialVersionUID = 7979028074367922595L;

    private Integer id;
    private String type;
    private String description;
    private Integer floor;
    private String number;
    private String sector;
    private Double squareMeters;
    private Boolean requiresApportion;
    private Boolean mainProperty;
    private Double apportionFactor;


}
