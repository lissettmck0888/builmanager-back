package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso,Integer> {

}
