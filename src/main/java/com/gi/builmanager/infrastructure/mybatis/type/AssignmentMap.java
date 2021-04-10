package com.gi.builmanager.infrastructure.mybatis.type;

import com.gi.builmanager.domain.model.assignment.Assignment;
import com.gi.builmanager.domain.model.assignment.AssignmentDetails;
import com.gi.builmanager.domain.model.assignment.AssignmentId;
import com.gi.builmanager.domain.model.assignment.Property;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AssignmentMap {

    private Integer id;
    private Integer guestId;
    private String guestFullName;
    private String type;
    private String state;
    private Double totalSquareMeters;
    private LocalDateTime startDate;
    private List<PropertyMap> properties;

    public static class DomainMapper{

        public Assignment toDomain(AssignmentMap assignmentMap) {
            return Assignment.builder()
                    .id(AssignmentId.builder().id(assignmentMap.id).build())
                    .details(AssignmentDetails.builder()
                            .guestFullName(assignmentMap.guestFullName)
                            .guestId(assignmentMap.guestId)
                            .properties(properties(assignmentMap.properties))
                            .startDate(assignmentMap.startDate)
                            .type(assignmentMap.type)
                            .state(assignmentMap.state)
                            .totalSquareMeters(assignmentMap.totalSquareMeters)
                            .build()
                    )
                    .build();
        }

        private List<Property> properties(List<PropertyMap> propertyMaps) {
            return propertyMaps.stream().map(propertyMap ->
                Property.builder()
                        .apportionmentMark(propertyMap.getApportionmentMark())
                        .description(propertyMap.getDescription())
                        .floor(propertyMap.getFloor())
                        .id(propertyMap.getId())
                        .mainProperty(propertyMap.getMainProperty())
                        .number(propertyMap.getNumber())
                        .sector(propertyMap.getSector())
                        .squareMeters(propertyMap.getSquareMeters())
                        .type(propertyMap.getType())
                        .build()
            ).collect(Collectors.toList());
        }
    }

}
