package com.gi.builmanager.domain.model.assignment;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.Asignacion;
import com.gi.builmanager.infrastructure.mybatis.type.AssignmentType;

import java.util.List;

public interface AssignmentRepository extends BaseRepository<Assignment> {


    List<Assignment> activeAssignments();
    List<AssignmentType> activeAssignmentsMybatis();
    Double usedSquareMetersTotal();
}
