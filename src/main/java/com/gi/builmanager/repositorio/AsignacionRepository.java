package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Asignacion;
import com.gi.builmanager.dominio.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Integer> {
    //List<Asignacion> findByAsignacion_IdAsignacion(int idAsignacion);

}
