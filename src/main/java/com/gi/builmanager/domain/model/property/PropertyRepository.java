package com.gi.builmanager.domain.model.property;

import com.gi.builmanager.domain.shared.BaseRepository;
import com.gi.builmanager.infrastructure.hibernate.entity.Unidad;

import java.util.List;

public abstract class PropertyRepository extends BaseRepository<Property> {

    public abstract List<Property> retrieveFreeMainProperties();
    public abstract List<Property> retrieveFreeProperties();
    public abstract List<Property> retrieveFreeMainPropertiesForRent();

}
