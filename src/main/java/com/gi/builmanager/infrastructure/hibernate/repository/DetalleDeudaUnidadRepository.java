package com.gi.builmanager.infrastructure.hibernate.repository;/*
package com.gi.builmanager.infrastructure.hibernate.repository;

import com.gi.builmanager.infrastructure.hibernate.entity.DetalleDeudadUnidad;
import com.gi.builmanager.infrastructure.hibernate.repository.projection.DetalleDeudaUnidadView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DetalleDeudaUnidadRepository extends JpaRepository<DetalleDeudadUnidad,Integer> {

    List<DetalleDeudaUnidadView> findByUnidad_IdUnidad(int idUnidad);
    List<DetalleDeudadUnidad> findByGastoComun_Periodo(LocalDate periodo);
}
*/
