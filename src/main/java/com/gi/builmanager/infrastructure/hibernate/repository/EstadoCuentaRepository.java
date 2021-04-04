package com.gi.builmanager.infrastructure.hibernate.repository;

import com.gi.builmanager.infrastructure.hibernate.entity.EstadoCuenta;
import com.gi.builmanager.infrastructure.hibernate.entity.GastoComun;
import com.gi.builmanager.infrastructure.hibernate.entity.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoCuentaRepository extends JpaRepository<EstadoCuenta, Integer> {

    List<EstadoCuenta> findByGastoComunOrderById(GastoComun gastoComun);
    EstadoCuenta findByGastoComunAndUnidad_idUnidad(GastoComun gastoComun, Integer idUnidad);
}
