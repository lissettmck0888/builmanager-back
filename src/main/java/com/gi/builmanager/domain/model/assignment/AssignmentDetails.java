package com.gi.builmanager.domain.model.assignment;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class AssignmentDetails implements ValueObject<AssignmentDetails> {

    private Integer guestId;
    private String guestFullName;
    private String type;
    private String state;
    private Double totalSquareMeters;
    private LocalDateTime startDate;
    private List<Property> properties;

    @Override
    public boolean sameValueAs(AssignmentDetails another) {
        return false;
    }

}
