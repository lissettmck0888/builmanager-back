package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad,Integer> {

    @Query(value =
            "select * from " +
            "unidad u where idunidad not in (select idunidad from relacion_asignacion_unidad)", nativeQuery = true)
    List<Unidad> getUnidadesDisponiblesSinPropietario();

    @Query(value = "select * from " +
            "asignacion a " +
            "join relacion_asignacion_unidad rau on a.id_asignacion=rau.idasignacion " +
            "where a.tipo_asignacion= 'propietario' and estado='vacio'", nativeQuery = true)
    List<Unidad> getUnidadesDisponiblesParaArriendo();

}
