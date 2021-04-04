package com.gi.builmanager.interfaces.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ExpensePeriodDto {

    private Integer id;
    private Double totalAmount;
    private LocalDate period;
}
