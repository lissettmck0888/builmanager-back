package com.gi.builmanager.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseItemValueDto {

    private Integer id;
    private Double amount;
    private String name;
    private String description;
    private String type;
}
