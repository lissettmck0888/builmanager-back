package com.gi.builmanager.interfaces.web;

import com.gi.builmanager.domain.model.property.PropertyRepository;
import com.gi.builmanager.interfaces.dto.PropertyDto;
import com.gi.builmanager.interfaces.mapper.PropertyWebMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/unidades")
public class UnidadController {

    @Autowired
    private PropertyWebMapper propertyWebMapper;

    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping("/sin-asignacion/unidad-copropiedad")
    public List<PropertyDto> getUnidadesCopropiedadDisponiblesSinPropietario() {
        return propertyRepository.retrieveFreeMainProperties().stream()
                .map(property -> propertyWebMapper.toDto(property))
                .collect(Collectors.toList());
    }

    @GetMapping("/sin-asignacion/")
    public List<PropertyDto> getUnidadesDisponiblesSinPropietario() {
        return propertyRepository.retrieveFreeProperties().stream()
                .map(property -> propertyWebMapper.toDto(property))
                .collect(Collectors.toList());
    }

    @GetMapping("/disponibles")
    public List<PropertyDto> getUnidadesDisponiblesParaArriendo() {
        return propertyRepository.retrieveFreeMainPropertiesForRent().stream()
                .map(property -> propertyWebMapper.toDto(property))
                .collect(Collectors.toList());
    }

}
