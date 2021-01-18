package com.gi.builmanager.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingDto {

    public Integer id;
    public String responsable;
    public Double periodDebt;
    public Double previousPeriodDebt;
    public Double balance;
    public Double apportionFactor;
    public String state;
    public LocalDateTime paymentDate;
    public String unidad;
    /*public gastoComun: GastoComun;*/


}
