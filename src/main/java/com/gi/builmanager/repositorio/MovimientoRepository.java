package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.dominio.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

    List<Movimiento> findByGastoComun(GastoComun gastoComun);
    List<Movimiento> findByGastoComunAndTipo(GastoComun gastoComun, String tipo);
}
