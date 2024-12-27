package com.example.studentsystem.controller;

import java.util.List;
import java.util.Optional;

import com.example.studentsystem.Service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentsystem.model.Professeur;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Professeur>> getAllProfesseurs() {
        List<Professeur> professeurs = professeurService.getAllProfesseurs();
        return ResponseEntity.ok(professeurs);
    }

    // Récupérer un professeur par code
    @GetMapping("/{code}")
    public ResponseEntity<Professeur> getProfesseurByCode(@PathVariable Long code) {
        Optional<Professeur> professeur = professeurService.getProfesseurByCode(code);
        return professeur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{code}")
    public ResponseEntity<Professeur> updateProfesseur(@PathVariable Long code, @RequestBody Professeur professeur) {
        // Retrieve the existing Professeur to check if it exists
        Optional<Professeur> existingProfesseur = professeurService.getProfesseurByCode(code);

        if (existingProfesseur.isPresent()) {
            Professeur updatedProfesseur = existingProfesseur.get();
            // Update the fields from the request body
            updatedProfesseur.setNom(professeur.getNom());
            updatedProfesseur.setPrenom(professeur.getPrenom());
            updatedProfesseur.setUsername(professeur.getUsername());
            updatedProfesseur.setPassword(professeur.getPassword());
            updatedProfesseur.setImage(professeur.getImage());
            updatedProfesseur.setSpecialite(professeur.getSpecialite());
            updatedProfesseur.setElements(professeur.getElements());

            // Save the updated Professeur
            Professeur savedProfesseur = professeurService.saveOrUpdateProfesseur(updatedProfesseur);
            return ResponseEntity.ok(savedProfesseur);
        } else {
            return ResponseEntity.notFound().build(); // If the Professeur is not found
        }
    }

    // Ajouter ou mettre à jour un professeur
    @PostMapping
    public ResponseEntity<Professeur> saveOrUpdateProfesseur(@RequestBody Professeur professeur) {
        Professeur savedProfesseur = professeurService.saveOrUpdateProfesseur(professeur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProfesseur);
    }

    // Supprimer un professeur
    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable Long code) {
        professeurService.deleteProfesseur(code);
        return ResponseEntity.noContent().build();
    }

    // Récupérer un professeur par nom d'utilisateur
    @GetMapping("/by-nom-utilisateur")
    public ResponseEntity<Professeur> getProfesseurByNomUtilisateur(@RequestParam String nomUtilisateur) {
        Professeur professeur = professeurService.getProfesseurByNomUtilisateur(nomUtilisateur);
        if (professeur != null) {
            return ResponseEntity.ok(professeur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
