package com.gi.builmanager.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentPropertyDto implements Serializable {

    private static final long serialVersionUID = 162871941915104301L;

    private PropertyDto propertyDto;
    private Boolean mainProperty;//unidad copropiedad

}
