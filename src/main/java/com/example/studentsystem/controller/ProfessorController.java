package com.example.studentsystem.controller;

import com.example.studentsystem.model.Professor;
import com.example.studentsystem.model.User;
import com.example.studentsystem.repository.UserRepository;
import com.example.studentsystem.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/professors")
class ProfessorController {
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        return ResponseEntity.ok(professorService.getAllProfessors());
    }

    @PostMapping
    public ResponseEntity<Professor> addProfessor(@RequestBody Professor professor) {
        // Check if the user exists before proceeding
        User user = userRepository.findById(professor.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(professorService.addProfessor(professor));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable int id, @RequestBody Professor professorDetails) {
        return ResponseEntity.ok(professorService.updateProfessor(id, professorDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable int id) {
        professorService.deleteProfessor((long) id);
        return ResponseEntity.noContent().build();
    }
}
