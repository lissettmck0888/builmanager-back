package com.gi.builmanager.interfaces.web;

import com.gi.builmanager.application.AssignmentService;
import com.gi.builmanager.domain.model.assignment.AssignmentRepository;
import com.gi.builmanager.interfaces.dto.AssignmentDto;
import com.gi.builmanager.interfaces.mapper.AssignmentWebMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/asignacion")
@CrossOrigin(origins = {"*"})
public class AsignacionController {

    @Autowired
    private AssignmentWebMapper assignmentWebMapper;

    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private AssignmentRepository assignmentRepository;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void guardarAsignacion(@RequestBody AssignmentDto assignmentDto) {
        assignmentService.newAssignment(assignmentWebMapper.fromDto(assignmentDto));
    }

    @GetMapping("/all")
    public List<AssignmentDto> getAsignaciones() {
        return assignmentRepository.activeAssignments().stream()
                .map(assignment -> assignmentWebMapper.toDto(assignment))
                .collect(Collectors.toList());
    }
}
