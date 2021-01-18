package com.gi.builmanager.interfaces.web;

import com.gi.builmanager.application.GuestService;
import com.gi.builmanager.domain.model.guest.GuestRepository;
import com.gi.builmanager.interfaces.dto.GuestDto;
import com.gi.builmanager.interfaces.mapper.GuestWebMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = {"*"})
public class PersonaController {

    @Autowired
    private GuestWebMapper guestWebMapper;

    @Autowired
    private GuestService guestService;
    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/")
    public List<GuestDto> getByFilter(@RequestParam String filter) {
        return guestRepository.retrieveByCoincidence(filter).stream()
                .map(guest -> guestWebMapper.toDto(guest))
                .collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<GuestDto> getAll() {
        return guestRepository.retrieveAll().stream()
                .map(guest -> guestWebMapper.toDto(guest))
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void agregarPersona(@RequestBody GuestDto persona) {
        guestService.createOrUpdateGuest(guestWebMapper.fromDto(persona));
    }
}
