package com.gi.builmanager.infrastructure.hibernate.repository;

import com.gi.builmanager.infrastructure.hibernate.entity.Abono;

import java.time.LocalDate;
import java.util.List;

////@Repository
public interface AbonosRepository /*extends JpaRepository<Abono, Integer> */{

    List<Abono> findAllByDetalleDeudadUnidad_unidad_IdUnidad(Integer idUnidad);
    List<Abono> findAllByDetalleDeudadUnidad_gastoComun_periodo(LocalDate periodo);

}
