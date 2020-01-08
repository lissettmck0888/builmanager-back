package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.RelacionPersonaUnidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelacionPersonaUnidadRepository extends JpaRepository<RelacionPersonaUnidad,Integer> {

    List<RelacionPersonaUnidad> findByPersona_IdPersona(int idPersona);
}
