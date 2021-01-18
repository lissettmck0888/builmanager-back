package com.gi.builmanager.domain.model.guest;

import com.gi.builmanager.domain.shared.AggregateRoot;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Guest extends AggregateRoot<Guest> {

    private GuestId id;
    private GuestDetails details;

    public Guest(GuestId id, GuestDetails details) {
        this.id = id;
        this.details = details;
    }

    @Override
    public boolean sameEntityAs(Guest another) {
        return false;
    }
}
