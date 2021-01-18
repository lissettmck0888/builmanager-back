package com.gi.builmanager.domain.model.guest;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GuestDetails implements ValueObject<GuestDetails> {

    private String name;
    private String lastNameP;
    private String lastNameM;
    private String rut;
    private LocalDate birthDate;
    private String nationality;
    private String phone;
    private String email;
    private String address;

    @Override
    public boolean sameValueAs(GuestDetails another) {
        return false;
    }
}
