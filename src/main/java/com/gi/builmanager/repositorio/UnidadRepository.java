package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad,Integer> {
}
