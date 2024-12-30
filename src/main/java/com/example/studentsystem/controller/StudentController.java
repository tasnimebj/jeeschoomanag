package com.example.studentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.studentsystem.model.Etudiant;
import com.example.studentsystem.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Get all students
    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return studentService.getAllEtudiants();
    }

    // Get students by filiere ID
    @GetMapping("/filiere/{filiereId}")
    public List<Etudiant> getEtudiantsByFiliere(@PathVariable Long filiereId) {
        return studentService.getEtudiantsByFiliere(filiereId);
    }

    // Add a new student
    @PostMapping
    public Etudiant addEtudiant(@RequestBody Etudiant newEtudiant) {
        return studentService.addEtudiant(newEtudiant);
    }

    // Update a student
    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id, @RequestBody Etudiant updatedEtudiant) {
        return studentService.updateEtudiant(id, updatedEtudiant);
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        studentService.deleteEtudiant(id);
    }
}
