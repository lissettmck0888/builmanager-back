package com.gi.builmanager.infrastructure.hibernate.repository;

import com.gi.builmanager.infrastructure.hibernate.entity.Asignacion;
import com.gi.builmanager.infrastructure.hibernate.repository.projection.AsignacionView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Integer> {

    //List<Asignacion> findByAsignacion_IdAsignacion(int idAsignacion);

    List<AsignacionView> findAllProjectedBy();

}
