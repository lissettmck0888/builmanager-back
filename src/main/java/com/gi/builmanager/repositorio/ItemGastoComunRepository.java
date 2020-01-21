package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.ItemGastoComun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemGastoComunRepository extends JpaRepository<ItemGastoComun, Integer> {
}
