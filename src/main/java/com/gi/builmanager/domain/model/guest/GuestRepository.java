package com.gi.builmanager.domain.model.guest;

import com.gi.builmanager.domain.shared.BaseRepository;

import java.util.List;

public interface GuestRepository extends BaseRepository<Guest> {

    List<Guest> retrieveAll();
    List<Guest> retrieveByCoincidence(String match);
}
