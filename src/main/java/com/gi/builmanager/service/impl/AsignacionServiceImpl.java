package com.gi.builmanager.service.impl;

import com.gi.builmanager.dominio.Asignacion;
import com.gi.builmanager.repositorio.AsignacionRepository;
import com.gi.builmanager.repositorio.projection.AsignacionView;
import com.gi.builmanager.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionServiceImpl implements AsignacionService {
    @Autowired
    private AsignacionRepository asignacionRepository;

    @Override
    public Asignacion save(Asignacion asignacion) {
        asignacion.setTotalMetrosCuadradosProrrateables(0D);
        asignacion.getAsignacionUnidads().stream().forEach(asignacionUnidad -> {
            asignacion.setTotalMetrosCuadradosProrrateables(
                    asignacion.getTotalMetrosCuadradosProrrateables() +
                            (asignacionUnidad.getUnidad().getAfectoProrrateo() ? asignacionUnidad.getUnidad().getMetrosCuadrados() : 0));
        });
        return asignacionRepository.save(asignacion);
    }

    @Override
    public List<AsignacionView> getAll() {
        return asignacionRepository.findAllProjectedBy();
    }

}
