package com.gi.builmanager.domain.model.guest;

import com.gi.builmanager.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class GuestId implements ValueObject<GuestId> {

    private Integer id;

    @Override
    public boolean sameValueAs(GuestId another) {
        return false;
    }
}
