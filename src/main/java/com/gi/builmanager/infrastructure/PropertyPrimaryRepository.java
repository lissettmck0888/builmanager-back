package com.gi.builmanager.infrastructure;

import com.gi.builmanager.domain.model.property.Property;
import com.gi.builmanager.domain.model.property.PropertyRepository;
import com.gi.builmanager.infrastructure.hibernate.repository.UnidadRepository;
import com.gi.builmanager.infrastructure.mapper.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PropertyPrimaryRepository implements PropertyRepository {

    @Autowired
    private PropertyMapper propertyMapper;

    @Autowired
    private UnidadRepository unidadRepository;

    @Override
    public List<Property> retrieveFreeMainProperties() {
        return unidadRepository.getUnidadesDisponiblesSinPropietario(true).stream()
                .map(unidad -> propertyMapper.fromRepositoryType(unidad))
                .collect(Collectors.toList());
    }

    @Override
    public List<Property> retrieveFreeProperties() {
        return unidadRepository.getUnidadesDisponiblesSinPropietario(false).stream()
                .map(unidad -> propertyMapper.fromRepositoryType(unidad))
                .collect(Collectors.toList());
    }

    @Override
    public List<Property> retrieveFreeMainPropertiesForRent() {
        return unidadRepository.getUnidadesDisponiblesParaArriendo().stream()
                .map(unidad -> propertyMapper.fromRepositoryType(unidad))
                .collect(Collectors.toList());
    }

    @Override
    public Property getById(Integer id) {
        return  propertyMapper.fromRepositoryType(unidadRepository.findById(id).orElse(null));
    }

    @Override
    public Integer save(Property aggregate) {
        return null;
    }

    @Override
    public Integer saveAll(List<Property> aggregate) {
        return null;
    }
}
