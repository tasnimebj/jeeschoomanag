package com.example.studentsystem.controller;

import com.example.studentsystem.model.Filiere;
import com.example.studentsystem.Service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    // Get all Filieres
    @GetMapping
    public List<Filiere> getAllFilieres() {
        return filiereService.getAllFilieres();
    }

    // Get Filiere by ID
    @GetMapping("/{id}")
    public ResponseEntity<Filiere> getFiliereById(@PathVariable Long id) {
        Optional<Filiere> filiere = filiereService.getFiliereById(id);
        return filiere.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new Filiere
    @PostMapping("add")
    public ResponseEntity<Filiere> createFiliere(@RequestBody Filiere filiere) {
        Filiere createdFiliere = filiereService.createFiliere(filiere);
        return new ResponseEntity<>(createdFiliere, HttpStatus.CREATED);
    }

    // Update an existing Filiere
    @PutMapping("/{id}")
    public ResponseEntity<Filiere> updateFiliere(@PathVariable Long id, @RequestBody Filiere filiere) {
        Filiere updatedFiliere = filiereService.updateFiliere(id, filiere);
        return updatedFiliere != null ? ResponseEntity.ok(updatedFiliere) : ResponseEntity.notFound().build();
    }

    // Delete a Filiere
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        return filiereService.deleteFiliere(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
