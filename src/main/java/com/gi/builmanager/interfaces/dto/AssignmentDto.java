package com.gi.builmanager.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentDto implements Serializable {

    private static final long serialVersionUID = 1773117738288265197L;

    private Integer id;
    private Integer guestId;
    private String guestFullName;
    private String assignmentType;
    private String state;
    private LocalDateTime assignmentDate;
    private List<PropertyDto> properties;


}
