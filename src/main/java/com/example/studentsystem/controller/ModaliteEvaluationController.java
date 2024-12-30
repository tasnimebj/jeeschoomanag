package com.example.studentsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentsystem.model.ModaliteEvaluation;
import com.example.studentsystem.Service.ModaliteEvaluationService;

@RestController
@RequestMapping("/api/modalites")
public class ModaliteEvaluationController {

    @Autowired
    private ModaliteEvaluationService modaliteEvaluationService;

    // Récupérer toutes les modalités
    @GetMapping
    public ResponseEntity<List<ModaliteEvaluation>> getAllModalites() {
        List<ModaliteEvaluation> modalites = modaliteEvaluationService.getAllModalites();
        return ResponseEntity.ok(modalites);
    }

    // Récupérer une modalité par ID
    @GetMapping("/{id}")
    public ResponseEntity<ModaliteEvaluation> getModaliteById(@PathVariable Long id) {
        Optional<ModaliteEvaluation> modalite = modaliteEvaluationService.getModaliteById(id);
        return modalite.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModaliteEvaluation> updateEvaluationMode(@PathVariable Long id, @RequestBody ModaliteEvaluation evaluationMode) {
        ModaliteEvaluation updatedMode = modaliteEvaluationService.update(id, evaluationMode);

        if (updatedMode != null) {
            return ResponseEntity.ok(updatedMode);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Ajouter ou mettre à jour une modalité
    @PostMapping
    public ResponseEntity<ModaliteEvaluation> saveOrUpdateModalite(@RequestBody ModaliteEvaluation modalite) {
        ModaliteEvaluation savedModalite = modaliteEvaluationService.saveOrUpdateModalite(modalite);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedModalite);
    }

    // Supprimer une modalité par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModalite(@PathVariable Long id) {
        modaliteEvaluationService.deleteModalite(id);
        return ResponseEntity.noContent().build();
    }

    // Récupérer une modalité par type
    @GetMapping("/by-type")
    public ResponseEntity<ModaliteEvaluation> getModaliteByType(@RequestParam String typeModalite) {
        ModaliteEvaluation modalite = modaliteEvaluationService.getModaliteByType(typeModalite);
        if (modalite != null) {
            return ResponseEntity.ok(modalite);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
