package com.example.studentsystem.controller;

import com.example.studentsystem.model.Professor;
import com.example.studentsystem.model.User;
import com.example.studentsystem.repository.UserRepository;
import com.example.studentsystem.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // Create a new professor
    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        Professor createdProfessor = professorService.createProfessor(professor);
        return new ResponseEntity<>(createdProfessor, HttpStatus.CREATED);
    }

    // Get all professors
    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    // Get a professor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable("id") int professorId) {
        Optional<Professor> professor = professorService.getProfessorById(professorId);
        if (professor.isPresent()) {
            return new ResponseEntity<>(professor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a professor
    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable("id") int professorId, @RequestBody Professor professor) {
        Professor updatedProfessor = professorService.updateProfessor(professorId, professor);
        if (updatedProfessor != null) {
            return new ResponseEntity<>(updatedProfessor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a professor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable("id") int professorId) {
        professorService.deleteProfessor(professorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
