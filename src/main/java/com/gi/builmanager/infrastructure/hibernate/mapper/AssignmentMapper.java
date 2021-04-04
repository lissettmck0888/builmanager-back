package com.gi.builmanager.infrastructure.hibernate.mapper;

import com.gi.builmanager.domain.model.assignment.Assignment;
import com.gi.builmanager.domain.model.assignment.AssignmentDetails;
import com.gi.builmanager.domain.model.assignment.Property;
import com.gi.builmanager.infrastructure.hibernate.entity.Persona;
import com.gi.builmanager.infrastructure.hibernate.repository.projection.AsignacionView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssignmentMapper implements RepositoryMapper<Assignment, AsignacionView> {
    @Override
    public Assignment fromRepositoryType(AsignacionView asignacionView) {

        List<Property> propertyList = asignacionView.getAsignacionUnidads().stream()
                .map(asignacionUnidadView -> Property.builder()
                        .type(asignacionUnidadView.getUnidad().getTipoUnidad().getNombre())
                        .apportionmentMark(asignacionUnidadView.getUnidadCopropiedad())
                        .id(asignacionUnidadView.getUnidad().getIdUnidad())
                        //.description(asignacionUnidadView.getUnidad().)
                        .floor(asignacionUnidadView.getUnidad().getPiso())
                        .mainProperty(asignacionUnidadView.getUnidadCopropiedad())
                        .sector(asignacionUnidadView.getUnidad().getSector())
                        .number(asignacionUnidadView.getUnidad().getNumero())
                        .squareMeters(asignacionUnidadView.getUnidad().getMetrosCuadrados())
                        .build()
                )
                .collect(Collectors.toList());
        return Assignment.builder()
                .details(AssignmentDetails.builder()
                        .guestId(asignacionView.getPersona().getIdPersona())
                        .guestFullName(fullName(asignacionView.getPersona()))
                        .type(asignacionView.getTipoAsignacion())
                        .startDate(asignacionView.getFechaAsignacion())
                        .state(asignacionView.getEstado())
                        .totalSquareMeters(asignacionView.getTotalMetrosCuadradosProrrateables())
                        .properties(propertyList)
                        .build())
                .build();
    }

    @Override
    public AsignacionView toRepository(Assignment assignment) {
        return null;
    }

    public String fullName(Persona persona) {
        return String.format("%s %s %s",
                persona.getNombres(),
                persona.getApellidoPaterno(),
                persona.getApellidoMaterno());
    }
}
