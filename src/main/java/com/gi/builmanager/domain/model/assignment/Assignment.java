package com.gi.builmanager.domain.model.assignment;

import com.gi.builmanager.domain.shared.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
public class Assignment extends AggregateRoot<Assignment> {

    private AssignmentId id;
    private AssignmentDetails details;

    public Property mainProperty() {
        Optional<Property> optionalProperty =
                details.getProperties().stream().filter(Property::getMainProperty).findFirst();
        return optionalProperty.orElse(null);
    }

    @Override
    public boolean sameEntityAs(Assignment another) {
        return false;
    }

}
