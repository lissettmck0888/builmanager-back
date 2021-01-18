package com.gi.builmanager.infrastructure.hibernate.repository;

import com.gi.builmanager.infrastructure.hibernate.entity.PlantillaGastosOrdinarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantillaGastosOrdinariosRepository extends JpaRepository<PlantillaGastosOrdinarios, Integer> {

    @Query(value = "select p from PlantillaGastosOrdinarios p where p.activo = true")
    List<PlantillaGastosOrdinarios> findByActivoEqualsTrue();
}
