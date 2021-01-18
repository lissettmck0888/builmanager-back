package com.gi.builmanager.security.authentication.repository;

import com.gi.builmanager.security.authentication.repository.entity.Rol;
import com.gi.builmanager.security.authentication.repository.projection.RolView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {

    List<RolView> findAllProjectedBy();
}
