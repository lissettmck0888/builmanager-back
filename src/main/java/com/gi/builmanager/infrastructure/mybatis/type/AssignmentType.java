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
public class AssignmentType {

    private Integer id;
    private Integer guestId;
    private String guestFullName;
    private String type;
    private String state;
    private Double totalSquareMeters;
    private LocalDateTime startDate;
    private List<PropertyType> properties;

    public static class DomainMapper{

        public Assignment toDomain(AssignmentType assignmentType) {
            return Assignment.builder()
                    .id(AssignmentId.builder().id(assignmentType.id).build())
                    .details(AssignmentDetails.builder()
                            .guestFullName(assignmentType.guestFullName)
                            .guestId(assignmentType.guestId)
                            .properties(properties(assignmentType.properties))
                            .startDate(assignmentType.startDate)
                            .type(assignmentType.type)
                            .state(assignmentType.state)
                            .totalSquareMeters(assignmentType.totalSquareMeters)
                            .build()
                    )
                    .build();
        }

        private List<Property> properties(List<PropertyType> propertyTypes) {
            return propertyTypes.stream().map(propertyType ->
                Property.builder()
                        .apportionmentMark(propertyType.getApportionmentMark())
                        .description(propertyType.getDescription())
                        .floor(propertyType.getFloor())
                        .id(propertyType.getId())
                        .mainProperty(propertyType.getMainProperty())
                        .number(propertyType.getNumber())
                        .sector(propertyType.getSector())
                        .squareMeters(propertyType.getSquareMeters())
                        .type(propertyType.getType())
                        .build()
            ).collect(Collectors.toList());
        }
    }

}
