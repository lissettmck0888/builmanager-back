package com.gi.builmanager.domain.model.assignment;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.Asignacion;

import java.util.List;

public interface AssignmentRepository extends BaseRepository<Assignment> {


    List<Assignment> activeAssignments();
    Double usedSquareMetersTotal();
}
