package com.gi.builmanager.infrastructure.mapper;

import com.gi.builmanager.domain.model.property.Property;
import com.gi.builmanager.domain.model.property.PropertyDetails;
import com.gi.builmanager.domain.model.property.PropertyId;
import com.gi.builmanager.infrastructure.hibernate.entity.Unidad;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapper implements RepositoryMapper<Property, Unidad> {

    @Override
    public Property fromRepositoryType(Unidad unidad) {
        return Property.builder()
                .id(PropertyId.builder().id(unidad.getIdUnidad()).build())
                .mainProperty(unidad.getEsUnidadCopropiedad())
                .details(PropertyDetails.builder()
                        .type(unidad.getTipoUnidad().getNombre())
                        .sector(unidad.getSector())
                        .floor(unidad.getPiso())
                        .number(unidad.getNumero())
                        .apportionmentMark(unidad.getAfectoProrrateo())
                        .squareMeters(unidad.getMetrosCuadrados())
                        .description(unidad.getDescripcion())
                        .build())
                .build();
    }

    @Override
    public Unidad toRepository(Property property, RepositoryHelper<Property, Unidad> repositoryHelper) {
        return null;
    }
}
