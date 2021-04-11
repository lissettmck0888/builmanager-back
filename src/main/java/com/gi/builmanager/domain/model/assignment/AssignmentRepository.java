package com.gi.builmanager.domain.model.assignment;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.Asignacion;
import com.gi.builmanager.infrastructure.mybatis.type.AssignmentMap;

import java.util.List;

public abstract class AssignmentRepository extends BaseRepository<Assignment> {

    public abstract List<Assignment> activeAssignments();
    public abstract List<AssignmentMap> activeAssignmentsMybatis();
    public abstract Double usedSquareMetersTotal();
}
