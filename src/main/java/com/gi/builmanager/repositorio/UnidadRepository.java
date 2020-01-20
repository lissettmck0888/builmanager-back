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

    @Query(value = "select\n" +
            "*\n" +
            "from\n" +
            "unidad\n" +
            "where\n" +
            "idunidad in(\n" +
            "select\n" +
            "idunidad\n" +
            "from\n" +
            "(\n" +
            "SELECT\n" +
            "rau.idunidad,\n" +
            "string_agg(a.tipo_asignacion,\n" +
            "',') asignaciones\n" +
            "FROM\n" +
            "asignacion a\n" +
            "JOIN relacion_asignacion_unidad rau ON\n" +
            "a.id_asignacion = rau.idasignacion\n" +
            "group by\n" +
            "idunidad\n" +
            "having\n" +
            "asignaciones not ilike '%arriendo%' )\n" +
            ");\n", nativeQuery = true)
    List<Unidad> getUnidadesDisponiblesParaArriendo();

}
