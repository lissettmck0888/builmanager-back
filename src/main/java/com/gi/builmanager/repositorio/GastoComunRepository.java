package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.repositorio.projection.GastoComunView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface GastoComunRepository extends JpaRepository<GastoComun,Integer> {

    GastoComun findByEstado(String estado);
    GastoComun findByEstadoAndPeriodo(String estado, LocalDate periodo);
}
