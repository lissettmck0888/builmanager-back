package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad,Integer> {

    @Query(value = "select * from\n" +
            "(\n" +
            "select u.*,a.estado\n" +
            "from unidad u left outer join relacion_asignacion_unidad r\n" +
            "on u.idunidad=r.idunidad \n" +
            "left outer join asignacion a \n" +
            "on r.idasignacion = a.id_asignacion\n" +
            ") result\n" +
            "where result.estado = 'vacio' or estado is null", nativeQuery = true)
    List<Unidad> getUnidadesDisponibles();
}
