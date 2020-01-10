package com.gi.builmanager.repositorio;

import com.gi.builmanager.dominio.Usuario;
import com.gi.builmanager.repositorio.projection.UsuarioView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    List<UsuarioView> findAllProjectedBy();

}
