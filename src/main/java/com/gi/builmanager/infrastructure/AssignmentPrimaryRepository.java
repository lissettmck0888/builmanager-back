package com.gi.builmanager.infrastructure;

import com.gi.builmanager.domain.model.assignment.Assignment;
import com.gi.builmanager.domain.model.assignment.AssignmentRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.Asignacion;
import com.gi.builmanager.infrastructure.hibernate.entity.AsignacionUnidad;
import com.gi.builmanager.infrastructure.hibernate.entity.Persona;
import com.gi.builmanager.infrastructure.hibernate.entity.Unidad;
import com.gi.builmanager.infrastructure.hibernate.repository.AsignacionRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.PersonaRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.UnidadRepository;
import com.gi.builmanager.infrastructure.mapper.AssignmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AssignmentPrimaryRepository implements AssignmentRepository {

    @Autowired
    private AssignmentMapper assignmentMapper;

    @Autowired
    private AsignacionRepository asignacionRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private UnidadRepository unidadRepository;

    @Override
    public Assignment getById(Integer id) {
        return null;
    }

    @Override
    public Integer save(Assignment newAssignment) {

        List<Asignacion> asignacionViewList = asignacionRepository.findAll();
        /*List<Unidad> unidadList = asignacionViewList.stream()
                .flatMap(asignacionView -> asignacionView.getAsignacionUnidads().stream()
                        .map(AsignacionUnidad::getUnidad)
                ).collect(Collectors.toList());*/

        List<Unidad> unidadList = unidadRepository.findAll();

        Persona persona =
                personaRepository.findById(
                        newAssignment.getDetails().getGuestId()
                ).orElseThrow(IllegalArgumentException::new);

        Asignacion asignacion = new Asignacion();
        asignacion.setPersona(persona);
        asignacion.setTipoAsignacion(newAssignment.getDetails().getType());
        asignacion.setEstado(newAssignment.getDetails().getState());
        asignacion.setFechaAsignacion(newAssignment.getDetails().getStartDate());
        asignacion.setTotalMetrosCuadradosProrrateables(newAssignment.getDetails().getTotalSquareMeters());
        asignacion.setAsignacionUnidads(
                newAssignment.getDetails().getProperties().stream()
                .map(property -> {
                    AsignacionUnidad asignacionUnidad = new AsignacionUnidad();
                    asignacionUnidad.setAsignacion(asignacion);
                    asignacionUnidad.setUnidadCopropiedad(property.getMainProperty());
                    Optional<Unidad> realUnidad = unidadList.stream()
                            .filter(unidad -> unidad.getIdUnidad().equals(property.getId())).findFirst();
                    asignacionUnidad.setUnidad(realUnidad.orElseThrow(IllegalArgumentException::new));
                    return asignacionUnidad;
                }).collect(Collectors.toList())
        );

        return asignacionRepository.save(asignacion).getIdAsignacion();
    }

    @Override
    public List<Assignment> activeAssignments() {
        return asignacionRepository.findAllProjectedBy().stream()
                .map(asignacionView -> assignmentMapper.fromRepositoryType(asignacionView))
                .collect(Collectors.toList());
    }

    @Override
    public Double usedSquareMetersTotal() {
        return unidadRepository.totalMetrosCuadradosProrrateables();
    }
}
