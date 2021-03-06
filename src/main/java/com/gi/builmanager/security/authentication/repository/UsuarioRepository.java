package com.gi.builmanager.security.authentication.repository;

import com.gi.builmanager.security.authentication.repository.entity.Usuario;
import com.gi.builmanager.security.authentication.repository.projection.UsuarioView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByNombreUsuario(String nombreUsuario);
    Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
    List<UsuarioView> findAllProjectedBy();

}
