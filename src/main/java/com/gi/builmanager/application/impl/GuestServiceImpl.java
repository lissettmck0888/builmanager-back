package com.gi.builmanager.application.impl;

import com.gi.builmanager.application.GuestService;
import com.gi.builmanager.domain.model.guest.Guest;
import com.gi.builmanager.domain.model.guest.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Integer createOrUpdateGuest(Guest guest) {
        return guestRepository.save(guest);
    }
}
