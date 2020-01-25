package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.DetalleDeudadUnidad;
import com.gi.builmanager.repositorio.projection.DetalleDeudaUnidadView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DetalleDeudaUnidadRepository extends JpaRepository<DetalleDeudadUnidad,Integer> {

    List<DetalleDeudaUnidadView> findByUnidad_IdUnidad(int idUnidad);
    List<DetalleDeudadUnidad> findByGastoComun_Periodo(LocalDate periodo);
}
