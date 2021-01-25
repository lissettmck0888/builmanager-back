package com.gi.builmanager.application.impl;

import com.gi.builmanager.application.AssignmentService;
import com.gi.builmanager.domain.model.assignment.Assignment;
import com.gi.builmanager.domain.model.assignment.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public void newAssignment(Assignment assignment) {
        assignmentRepository.save(assignment, null);
    }
}
