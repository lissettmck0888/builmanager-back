package com.gi.builmanager.service.impl;

import com.gi.builmanager.repositorio.DetalleDeudaUnidadRepository;
import com.gi.builmanager.repositorio.projection.DetalleDeudaUnidadView;
import com.gi.builmanager.service.DetalleDeudaUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleDeudaUnidadServiceImpl implements DetalleDeudaUnidadService {

    @Autowired
    private DetalleDeudaUnidadRepository repository;

    @Override
    public List<DetalleDeudaUnidadView> getByUnidad(int idUnidad) {
        return repository.findByUnidad_IdUnidad(idUnidad);
    }
}
