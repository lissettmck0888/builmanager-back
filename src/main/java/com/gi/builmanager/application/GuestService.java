package com.gi.builmanager.application;

import com.gi.builmanager.domain.model.guest.Guest;

public interface GuestService {

    Integer createOrUpdateGuest(Guest guest);
}
