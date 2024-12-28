package com.example.studentsystem.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentsystem.model.Professeur;
import com.example.studentsystem.Service.ProfesseurService;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    // Get all professors
    @GetMapping
    public List<Professeur> getAllProfesseurs() {
        return professeurService.getAllProfesseurs();
    }

    // Add a new professor

    @PostMapping
    public Professeur addProfesseur(@RequestBody Professeur newProfesseur) {
        return professeurService.addProfesseur(newProfesseur);
    }

    // Update a professor
    @PutMapping("/{code}")
    public Professeur updateProfesseur(@PathVariable String code, @RequestBody Professeur updatedProfesseur) {
        return professeurService.updateProfesseur(code, updatedProfesseur);
    }

    // Delete a professor
    @DeleteMapping("/{code}")
    public void deleteProfesseur(@PathVariable String code) {
        professeurService.deleteProfesseur(code);
    }
}



