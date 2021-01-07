package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.repositorio.projection.GastoComunView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface GastoComunRepository extends JpaRepository<GastoComun,Integer> {

    GastoComun findByEstado(String estado);
    @Query(value = "select * from gasto_comun g where g.estado = 'Cerrado' order by idgastocomun desc limit 1", nativeQuery = true)
    Optional<GastoComun> findUltimoGastoComunCerrado();
    GastoComun findByEstadoAndPeriodo(String estado, LocalDate periodo);
}
