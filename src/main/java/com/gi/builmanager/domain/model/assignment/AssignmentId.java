package com.gi.builmanager.domain.model.assignment;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.Data;

@Data
public class AssignmentId implements ValueObject<AssignmentId> {

    private Integer id;

    @Override
    public boolean sameValueAs(AssignmentId another) {
        return false;
    }
}
