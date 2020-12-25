package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.EstadoCuenta;
import com.gi.builmanager.dominio.GastoComun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoCuentaRepository extends JpaRepository<EstadoCuenta, Integer> {

    List<EstadoCuenta> findByGastoComun(GastoComun gastoComun);
}
