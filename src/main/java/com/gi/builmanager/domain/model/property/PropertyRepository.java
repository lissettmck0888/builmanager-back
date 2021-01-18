package com.gi.builmanager.domain.model.property;

import com.gi.builmanager.domain.shared.BaseRepository;

import java.util.List;

public interface PropertyRepository extends BaseRepository<Property> {

    List<Property> retrieveFreeMainProperties();
    List<Property> retrieveFreeProperties();
    List<Property> retrieveFreeMainPropertiesForRent();

}
