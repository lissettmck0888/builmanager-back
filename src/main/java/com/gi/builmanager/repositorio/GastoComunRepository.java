package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.GastoComun;
import com.gi.builmanager.repositorio.projection.GastoComunView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoComunRepository extends JpaRepository<GastoComun,Integer> {

    GastoComunView findByEstado(String estado);
}
