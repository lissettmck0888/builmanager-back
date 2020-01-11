package com.gi.builmanager.converter;

import com.gi.builmanager.dominio.Permiso;
import com.gi.builmanager.dominio.Rol;
import com.gi.builmanager.dto.PermisoDto;
import com.gi.builmanager.dto.RolDDto;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class RolConverter implements Converter<RolDDto, Rol> {

    @Override
    public Rol convert(RolDDto rolDDto) {
        Rol rol = new Rol();
        rol.setIdRol(rolDDto.getIdRol());
        rol.setNombre(rolDDto.getNombre());
        rol.setPermisos(getListaPermiso(rolDDto.getPermisos()));
        return rol;
    }
    public List<Permiso> getListaPermiso(List<PermisoDto> listaDto){
        List<Permiso> lista = new ArrayList<>();
        listaDto.stream().forEach(permisoDto -> {
            Permiso permiso = new Permiso();
            permiso.setIdPermiso(permisoDto.getIdPermiso());
            permiso.setCodigo(permisoDto.getCodigo());
            permiso.setNombre(permisoDto.getNombre());
            permiso.setDescripcion(permisoDto.getDescripcion());
            lista.add(permiso);

        });
        return lista;
    }
}
