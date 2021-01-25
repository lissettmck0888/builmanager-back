package com.gi.builmanager.infrastructure.mapper;

import com.gi.builmanager.domain.model.guest.Guest;
import com.gi.builmanager.domain.model.guest.GuestDetails;
import com.gi.builmanager.domain.model.guest.GuestId;
import com.gi.builmanager.infrastructure.hibernate.entity.Persona;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper implements RepositoryMapper<Guest, Persona> {

    @Override
    public Guest fromRepositoryType(Persona persona) {
        return Guest.builder()
                .id(GuestId.builder().id(persona.getIdPersona()).build())
                .details(GuestDetails.builder()
                        .address(persona.getDireccion())
                        .birthDate(persona.getFechaNacimiento())
                        .email(persona.getCorreo())
                        .lastNameM(persona.getApellidoMaterno())
                        .lastNameP(persona.getApellidoPaterno())
                        .name(persona.getNombres())
                        .nationality(persona.getNacionalidad())
                        .rut(persona.getRun())
                        .phone(persona.getTelefono())
                        .build())
                .build();
    }

    @Override
    public Persona toRepository(Guest guest) {
        return Persona.builder()
                .apellidoMaterno(guest.getDetails().getLastNameM())
                .apellidoPaterno(guest.getDetails().getLastNameP())
                .nombres(guest.getDetails().getName())
                .direccion(guest.getDetails().getAddress())
                .correo(guest.getDetails().getEmail())
                .telefono(guest.getDetails().getPhone())
                .nacionalidad(guest.getDetails().getNationality())
                .run(guest.getDetails().getRut())
                .idPersona(guest.getId().getId())
                .build();
    }
}
