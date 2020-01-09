package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Rol;
import com.gi.builmanager.repositorio.projection.RolView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {

    List<RolView> findAllProjectedBy();
}
