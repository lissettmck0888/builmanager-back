package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
}
