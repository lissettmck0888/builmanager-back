package com.gi.builmanager.infrastructure.hibernate.repository;

import com.gi.builmanager.infrastructure.hibernate.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query(
            value = "select * from persona p " +
            "where p.run like concat('%',:filter,'%') " +
            "or lower(p.nombres) like lower(concat('%',:filter,'%')) " +
            "or lower(p.apellido_paterno) like lower(concat('%',:filter,'%')) " +
            "or lower(p.apellido_materno) like lower(concat('%',:filter,'%'))",
            nativeQuery = true)
    List<Persona> findByFilter(@Param("filter") String filter);
}
