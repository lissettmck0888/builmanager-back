package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Abonos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonosRepository extends JpaRepository<Abonos, Integer> {

}
