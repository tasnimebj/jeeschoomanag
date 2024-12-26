package com.example.studentsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentsystem.model.NoteElement;
import com.example.studentsystem.Repository.EtudiantRepository;
import com.example.studentsystem.Repository.NoteElementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NoteElementService {

    @Autowired
    private NoteElementRepository noteElementRepository;


    // Récupérer toutes les notes
    public List<NoteElement> getAllNotes() {
        return noteElementRepository.findAll();
    }

    // Récupérer une note par ID
    public Optional<NoteElement> getNoteById(Long id) {
        return noteElementRepository.findById(id);
    }

    // Ajouter ou mettre à jour une note
    public NoteElement saveOrUpdateNote(NoteElement noteElement) {
        return noteElementRepository.save(noteElement);
    }

    // Supprimer une note par ID
    public void deleteNote(Long id) {
        noteElementRepository.deleteById(id);
    }

}
