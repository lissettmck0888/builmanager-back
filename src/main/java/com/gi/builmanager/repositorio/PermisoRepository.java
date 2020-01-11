package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Permiso;
import com.gi.builmanager.repositorio.projection.PermisoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso,Integer> {

    List<PermisoView> findByRoles_idRol(int idRol);
    List<PermisoView> findByRoles_nombreIgnoreCase(String nombre);
    List<PermisoView> findAllProjectedBy();
}
