package com.example.studentsystem.controller;
import com.example.studentsystem.dto.FiliereDTO;
import com.example.studentsystem.model.Filiere;
import com.example.studentsystem.Service.FiliereService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;


import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    private final FiliereService filiereService;

    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @GetMapping
    public List<FiliereDTO> getAllFilieres() {
        return filiereService.getAllFilieres();
    }

    @PostMapping
    public ResponseEntity<FiliereDTO> createFiliere(@RequestBody FiliereDTO filiereDTO) {
        Filiere createdFiliere = filiereService.createFiliere(filiereDTO);
        return ResponseEntity.status(201).body(filiereDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        try {
            filiereService.deleteFiliere(id); // Call the service to delete
            return ResponseEntity.noContent().build(); // Return 204 status on success
        } catch (RuntimeException e) {
            // Handle the case where Filiere is not found
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<FiliereDTO> updateFiliere(@PathVariable Long id, @RequestBody FiliereDTO filiereDTO) {
        Filiere updatedFiliere = filiereService.updateFiliere(id, filiereDTO);
        return updatedFiliere != null
                ? ResponseEntity.ok(filiereDTO)
                : ResponseEntity.notFound().build();
    }
}
