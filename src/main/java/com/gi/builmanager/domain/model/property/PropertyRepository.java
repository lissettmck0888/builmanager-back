package com.gi.builmanager.domain.model.property;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.Unidad;

import java.util.List;

public interface PropertyRepository extends BaseRepository<Property, Unidad> {

    List<Property> retrieveFreeMainProperties();
    List<Property> retrieveFreeProperties();
    List<Property> retrieveFreeMainPropertiesForRent();

}
