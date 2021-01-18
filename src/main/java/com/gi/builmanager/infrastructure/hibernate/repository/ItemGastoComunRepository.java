package com.gi.builmanager.infrastructure.hibernate.repository;

import com.gi.builmanager.infrastructure.hibernate.entity.ItemGastoComun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemGastoComunRepository extends JpaRepository<ItemGastoComun, Integer> {

    List<ItemGastoComun> findAllByTipo(String tipo);
    ItemGastoComun findByNombre(String nombre);
}
