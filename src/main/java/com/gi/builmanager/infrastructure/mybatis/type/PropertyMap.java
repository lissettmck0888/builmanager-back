package com.gi.builmanager.infrastructure.mybatis.type;

import lombok.Data;

@Data
public class PropertyMap {

    private Integer id;
    private String type;
    private String description;
    private Integer floor;
    private String number;
    private String sector;
    private Double squareMeters;
    private Boolean apportionmentMark;
    private Boolean mainProperty; //unidadCopropiedad

}
