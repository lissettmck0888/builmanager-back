package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Unidad;
import com.gi.builmanager.repositorio.projection.UnidadView;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad,Integer> {

    @Query(value =
            "select u from " +
            "Unidad u where u not in (select au.unidad from AsignacionUnidad au) and u.esUnidadCopropiedad=:unidadCopropiedad")
    List<Unidad> getUnidadesDisponiblesSinPropietario(@Param("unidadCopropiedad") Boolean unidadCopropiedad);

    @Query(value = "select\n" +
            "*\n" +
            "from\n" +
            "unidad\n" +
            "where\n" +
            "idunidad in(\n" +
            "select\n" +
            "id_unidad\n" +
            "from\n" +
            "(\n" +
            "SELECT\n" +
            "rau.id_unidad,\n" +
            "string_agg(a.tipo_asignacion,\n" +
            "',') asignaciones\n" +
            "FROM\n" +
            "asignacion a\n" +
            "JOIN asignacion_unidad rau ON\n" +
            "a.id_asignacion = rau.id_asignacion\n" +
            "group by\n" +
            "id_unidad\n" +
            "having\n" +
            "asignaciones not ilike '%arriendo%' ))\n", nativeQuery = true)
    List<Unidad> getUnidadesDisponiblesParaArriendo();

}
