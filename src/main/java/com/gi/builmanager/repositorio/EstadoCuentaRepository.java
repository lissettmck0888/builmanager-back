package com.gi.builmanager.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCuentaRepository extends JpaRepository<EstadoCuentaRepository, Integer> {

}
