package com.gi.builmanager.infrastructure;

import com.gi.builmanager.domain.model.guest.Guest;
import com.gi.builmanager.domain.model.guest.GuestRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.Persona;
import com.gi.builmanager.infrastructure.hibernate.repository.PersonaRepository;
import com.gi.builmanager.infrastructure.hibernate.mapper.GuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class GuestPrimaryRepository extends GuestRepository {

    @Autowired
    private GuestMapper guestMapper;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Guest getById(Integer id) {
        return guestMapper.fromRepositoryType(personaRepository.findById(id).orElse(null));
    }

    @Override
    public Integer save(Guest guest) {

        Persona persona = new Persona();
        persona.setIdPersona(Objects.nonNull(guest.getId()) ? guest.getId().getId() : null);
        persona.setRun(guest.getDetails().getRut());
        persona.setNombres(guest.getDetails().getName());
        persona.setApellidoPaterno(guest.getDetails().getLastNameP());
        persona.setApellidoMaterno(guest.getDetails().getLastNameM());
        persona.setFechaNacimiento(guest.getDetails().getBirthDate());
        persona.setCorreo(guest.getDetails().getEmail());
        persona.setDireccion(guest.getDetails().getAddress());
        persona.setTelefono(guest.getDetails().getPhone());

        return personaRepository.save(persona).getIdPersona();

    }

    @Override
    public Integer saveAll(List<Guest> aggregate) {
        return null;
    }

    @Override
    public List<Guest> retrieveAll() {
        return personaRepository.findAll().stream()
                .map(persona -> guestMapper.fromRepositoryType(persona))
                .collect(Collectors.toList());
    }

    @Override
    public List<Guest> retrieveByCoincidence(String match) {
        return personaRepository.findByFilter(match).stream()
                .map(persona -> guestMapper.fromRepositoryType(persona))
                .collect(Collectors.toList());
    }
}
