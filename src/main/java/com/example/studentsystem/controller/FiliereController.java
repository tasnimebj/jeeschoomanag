package com.example.studentsystem.controller;
import com.example.studentsystem.model.Filiere;
import com.example.studentsystem.Service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    // Get all Filieres
    @GetMapping
    public ResponseEntity<List<Filiere>> getAllFilieres() {
        List<Filiere> filieres = filiereService.getAllFilieres();
        return ResponseEntity.ok(filieres);
    }

    // Get Filiere by ID
    @GetMapping("/{id}")
    public ResponseEntity<Filiere> getFiliereById(@PathVariable Long id) {
        Filiere filiere = filiereService.getFiliereById(id)
                .orElse(null);
        if (filiere == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(filiere);
    }

    // Create a new Filiere
    @PostMapping
    public ResponseEntity<Filiere> createFiliere(@Valid @RequestBody Filiere filiere) {
        Filiere createdFiliere = filiereService.createFiliere(filiere);
        return new ResponseEntity<>(createdFiliere, HttpStatus.CREATED);
    }

    // Update an existing Filiere
    @PutMapping("/{id}")
    public ResponseEntity<Filiere> updateFiliere(@PathVariable Long id, @Valid @RequestBody Filiere filiere) {
        Filiere updatedFiliere = filiereService.updateFiliere(id, filiere);
        return updatedFiliere != null ? ResponseEntity.ok(updatedFiliere) : ResponseEntity.notFound().build();
    }

    // Delete a Filiere
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        boolean deleted = filiereService.deleteFiliere(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
