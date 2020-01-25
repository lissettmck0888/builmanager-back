package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.ItemGastoComun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemGastoComunRepository extends JpaRepository<ItemGastoComun, Integer> {

    List<ItemGastoComun> findAllByTipo(String tipo);
}
