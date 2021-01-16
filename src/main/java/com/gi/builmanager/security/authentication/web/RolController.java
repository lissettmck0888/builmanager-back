package com.gi.builmanager.security.authentication.web;

import com.gi.builmanager.security.authentication.dto.RolDDto;
import com.gi.builmanager.security.authentication.repositorio.projection.RolView;
import com.gi.builmanager.security.authentication.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = {"*"})
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping("/")
    public List<RolView> getRolView(){
        return rolService.getRolView();

    }
    @PostMapping("/")
    public Boolean guardarRolDto(@RequestBody RolDDto rol){
        rolService.crearRol(rol);
        return true;
    }
}
