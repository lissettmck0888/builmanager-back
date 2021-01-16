package com.gi.builmanager.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestDto {

    private Integer id;
    private String name;
    private String lastNameP;
    private String lastNameM;
    private String rut;
    private LocalDate birthDate;
    private String nationality;
    private String phone;
    private String email;
    private String address;
}
