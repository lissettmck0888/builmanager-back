package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.EstadoCuenta;
import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.repositorio.projection.EstadoCuentaView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoCuentaRepository extends JpaRepository<EstadoCuenta, Integer> {

    List<EstadoCuenta> findByGastoComun(GastoComun gastoComun);
    List<EstadoCuentaView> findByUnidad_idUnidad(Integer idUnidad);
}
