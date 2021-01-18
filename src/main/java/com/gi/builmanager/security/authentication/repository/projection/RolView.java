package com.gi.builmanager.security.authentication.repository.projection;

import java.util.List;

public interface RolView {
    int getIdRol();
    String getNombre();
    List<PermisoView> getPermisos();
}
