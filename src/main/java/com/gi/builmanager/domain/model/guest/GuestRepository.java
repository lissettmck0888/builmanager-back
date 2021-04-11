package com.gi.builmanager.domain.model.guest;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.Persona;

import java.util.List;

public abstract class GuestRepository extends BaseRepository<Guest> {

    public abstract List<Guest> retrieveAll();
    public abstract List<Guest> retrieveByCoincidence(String match);
}
