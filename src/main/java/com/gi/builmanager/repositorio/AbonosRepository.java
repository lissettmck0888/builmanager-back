package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Abono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

////@Repository
public interface AbonosRepository /*extends JpaRepository<Abono, Integer> */{

    List<Abono> findAllByDetalleDeudadUnidad_unidad_IdUnidad(Integer idUnidad);
    List<Abono> findAllByDetalleDeudadUnidad_gastoComun_periodo(LocalDate periodo);

}
