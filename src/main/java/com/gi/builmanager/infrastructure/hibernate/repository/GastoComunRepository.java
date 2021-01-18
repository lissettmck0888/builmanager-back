package com.gi.builmanager.infrastructure.hibernate.repository;

import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface GastoComunRepository extends JpaRepository<GastoComun,Integer> {

    GastoComun findByEstado(String estado);
    @Query(value = "select * from gasto_comun g where g.estado = 'Cerrado' order by idgastocomun desc limit 1", nativeQuery = true)
    Optional<GastoComun> findUltimoGastoComunCerrado();
    GastoComun findByEstadoAndPeriodo(String estado, LocalDate periodo);
    GastoComun findByPeriodo(LocalDate periodo);

}
