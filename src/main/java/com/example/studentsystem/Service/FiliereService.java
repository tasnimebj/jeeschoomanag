package com.example.studentsystem.Service;
import com.example.studentsystem.model.Filiere;
import com.example.studentsystem.Repository.FiliereRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepository filiereRepository;

    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }

    public Optional<Filiere> getFiliereById(Long id) {
        return filiereRepository.findById(id);
    }

    public Filiere createFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }
    @Transactional

    public Filiere updateFiliere(Long id, Filiere filiere) {
        if (filiereRepository.existsById(id)) {
            filiere.setId(id);
            return filiereRepository.save(filiere);
        }
        return null; // Return null if not found
    }
    @Transactional

    public boolean deleteFiliere(Long id) {
        if (filiereRepository.existsById(id)) {
            filiereRepository.deleteById(id);
            return true;
        }
        return false; // Return false if not found
    }
}
