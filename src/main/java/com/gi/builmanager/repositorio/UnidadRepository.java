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
            "where a.estado ='vacio'\n" +
            "group by\n" +
            "id_unidad\n" +
            "having\n" +
            "asignaciones not ilike '%arriendo%' ))\n", nativeQuery = true)
    List<Unidad> getUnidadesDisponiblesParaArriendo();

    @Query(value = "select sum(u.metrosCuadrados) from Unidad u join AsignacionUnidad au on u.idUnidad=au.unidad where u.afectoProrrateo=true")
    Double totalMetrosCuadradosProrrateablesAsignados();

    @Query(value = "select\n" +
            "sum(m2)\n" +
            "from (\n" +
            "select 0 id_asignacion, 'vacio' estado, 0 metros2, u.metros_cuadrados m2 from unidad u left join asignacion_unidad au on u.idunidad=au.id_unidad where au.id_asignacion is null and u.afecto_prorrateo=true\n" +
            ") group by id_asignacion", nativeQuery = true)
    Double totalMetrosCuadradosProrrateablesNoAsignados();

    @Query(value = "select sum(u.metrosCuadrados) from Unidad u where u.afectoProrrateo=true")
    Double totalMetrosCuadradosProrrateables();

    /*
    * select sum(u.metros_cuadrados) from unidad u where u.afecto_prorrateo=true;
select sum(u.metros_cuadrados) from unidad u join asignacion_unidad au on u.idunidad=au.id_unidad where u.afecto_prorrateo=true;


-- metros cuadrados no asignados (corregir con query de abajo)
select
id_asignacion, sum(m2)
from (
select 0 id_asignacion, 'vacio' estado, 0 metros2, u.metros_cuadrados m2 from unidad u where u.afecto_prorrateo=true
) group by id_asignacion;


select * from unidad u left join asignacion_unidad au on u.idunidad=au.id_unidad where au.id_asignacion is null;
    * */
}
