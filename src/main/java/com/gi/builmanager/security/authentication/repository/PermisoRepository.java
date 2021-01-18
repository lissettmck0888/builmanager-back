package com.gi.builmanager.security.authentication.repository;

import com.gi.builmanager.security.authentication.repository.entity.Permiso;
import com.gi.builmanager.security.authentication.repository.projection.PermisoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso,Integer> {

    List<PermisoView> findByRoles_idRol(int idRol);
    List<PermisoView> findByRoles_nombreIgnoreCase(String nombre);
    List<PermisoView> findAllProjectedBy();
}
