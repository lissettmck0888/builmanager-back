package com.gi.builmanager.interfaces.mapper;

import com.gi.builmanager.domain.model.assignment.Assignment;
import com.gi.builmanager.domain.model.assignment.AssignmentDetails;
import com.gi.builmanager.domain.model.assignment.Property;
import com.gi.builmanager.interfaces.dto.AssignmentDto;
import com.gi.builmanager.interfaces.dto.AssignmentPropertyDto;
import com.gi.builmanager.interfaces.dto.PropertyDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssignmentWebMapper {

    public AssignmentDto toDto(Assignment assignment) {

        List<AssignmentPropertyDto> propertyDtoList = assignment.getDetails().getProperties().stream()
                .map(property -> AssignmentPropertyDto.builder()
                        .mainProperty(property.getMainProperty())
                        .propertyDto(PropertyDto.builder()
                                .id(property.getId())
                                .type(property.getType())
                                //.apportionFactor(property.get)
                                .description(property.getDescription())
                                .floor(property.getFloor())
                                .number(property.getNumber())
                                .sector(property.getSector())
                                .requiresApportion(property.getApportionmentMark())
                                .squareMeters(property.getSquareMeters())
                                .mainProperty(property.getMainProperty())
                                .build()
                        )
                        .build())
                .collect(Collectors.toList());

        return AssignmentDto.builder()
                .assignmentDate(assignment.getDetails().getStartDate())
                .assignmentType(assignment.getDetails().getType())
                .guestId(assignment.getDetails().getGuestId())
                .guestFullName(assignment.getDetails().getGuestFullName())
                .assignmentPropertyList(propertyDtoList)
                .build();
    }

    public Assignment fromDto(AssignmentDto assignmentDto) {
        List<Property> properties = assignmentDto.getAssignmentPropertyList().stream().map(asignacionUnidadDto -> Property.builder()
                .id(asignacionUnidadDto.getPropertyDto().getId())
                .mainProperty(asignacionUnidadDto.getMainProperty())
                .build()).collect(Collectors.toList());

        Double totalSquareMeters = assignmentDto.getAssignmentPropertyList().stream()
                .filter(asignacionUnidadDto -> asignacionUnidadDto.getPropertyDto().getRequiresApportion())
                .map(asig -> asig.getPropertyDto().getSquareMeters()).reduce(Double::sum)
                .orElse(0D);

        return Assignment.builder()
                .details(
                        AssignmentDetails.builder()
                                .guestId(assignmentDto.getGuestId())
                                .guestFullName(assignmentDto.getGuestFullName())
                                .startDate(assignmentDto.getAssignmentDate())
                                .state(assignmentDto.getState())
                                .type(assignmentDto.getAssignmentType())
                                .totalSquareMeters(totalSquareMeters)
                                .properties(properties)
                                .build()
                ).build();
    }
}
