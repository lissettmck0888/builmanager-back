package com.gi.builmanager.infrastructure.hibernate.repository.projection;

import java.util.List;

public interface RolView {
    int getIdRol();
    String getNombre();
    List<PermisoView> getPermisos();
}
