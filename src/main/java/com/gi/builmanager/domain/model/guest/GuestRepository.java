package com.gi.builmanager.domain.model.guest;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.Persona;

import java.util.List;

public interface GuestRepository extends BaseRepository<Guest, Persona> {

    List<Guest> retrieveAll();
    List<Guest> retrieveByCoincidence(String match);
}
