package com.gi.builmanager.controller;

import com.gi.builmanager.dominio.Persona;
import com.gi.builmanager.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = {"*"})
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public List<Persona> getByFilter(@RequestParam String filter) {
        return personaService.getByFilter(filter);
    }

    @GetMapping("/all")
    public List<Persona> getAll() {
        return personaService.getAll();
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Persona agregarPersona(@RequestBody Persona persona) {
        return personaService.agregar(persona);
    }

    @DeleteMapping(path = {"/{id}"})
    public boolean eliminarPersona(@PathVariable("id") int id){
        return personaService.eliminar(id);

    }
}
