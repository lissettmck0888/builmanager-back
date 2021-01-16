package com.gi.builmanager.interfaces.mapper;

import com.gi.buildman.domain.model.guest.Guest;
import com.gi.buildman.domain.model.guest.GuestDetails;
import com.gi.buildman.domain.model.guest.GuestId;
import com.gi.builmanager.interfaces.dto.GuestDto;
import org.springframework.stereotype.Component;

@Component
public class GuestWebMapper {

    public Guest fromDto(GuestDto persona) {
        return Guest.builder()
                .id(new GuestId(persona.getId()))
                .details(GuestDetails.builder()
                        .rut(persona.getRut())
                        .name(persona.getName())
                        .lastNameP(persona.getLastNameP())
                        .lastNameM(persona.getLastNameM())
                        .nationality(persona.getNationality())
                        .birthDate(persona.getBirthDate())
                        .phone(persona.getPhone())
                        .email(persona.getEmail())
                        .address(persona.getAddress())
                        .build())
                .build();
    }

    public GuestDto toDto(Guest guest) {
        return GuestDto.builder()
                .id(guest.getId().getId())
                .rut(guest.getDetails().getRut())
                .name(guest.getDetails().getName())
                .lastNameP(guest.getDetails().getLastNameP())
                .lastNameM(guest.getDetails().getLastNameM())
                .nationality(guest.getDetails().getNationality())
                .birthDate(guest.getDetails().getBirthDate())
                .phone(guest.getDetails().getPhone())
                .email(guest.getDetails().getEmail())
                .address(guest.getDetails().getAddress())
                .build();
    }
}
