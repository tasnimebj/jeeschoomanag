package com.example.studentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentsystem.model.NoteElement;
import com.example.studentsystem.Service.NoteElementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteElementController {

    @Autowired
    private NoteElementService noteElementService;

    // Récupérer toutes les notes
    @GetMapping
    public ResponseEntity<List<NoteElement>> getAllNotes() {
        List<NoteElement> notes = noteElementService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    // Récupérer une note par ID
    @GetMapping("/{id}")
    public ResponseEntity<NoteElement> getNoteById(@PathVariable Long id) {
        Optional<NoteElement> note = noteElementService.getNoteById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ajouter ou mettre à jour une note
    @PostMapping
    public ResponseEntity<NoteElement> saveOrUpdateNote(@RequestBody NoteElement noteElement) {
        NoteElement savedNote = noteElementService.saveOrUpdateNote(noteElement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
    }

    // Supprimer une note par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteElementService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }


}
