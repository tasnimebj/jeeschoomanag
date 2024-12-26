package com.example.studentsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentsystem.model.Semestre;
import com.example.studentsystem.Repository.SemestreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreService {

    @Autowired
    private SemestreRepository semestreRepository;

    // Récupérer tous les semestres
    public List<Semestre> getAllSemestres() {
        return semestreRepository.findAll();
    }

    // Récupérer un semestre par ID
    public Optional<Semestre> getSemestreById(Long id) {
        return semestreRepository.findById(id);
    }

    // Ajouter ou mettre à jour un semestre
    public Semestre saveOrUpdateSemestre(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    // Supprimer un semestre par ID
    public void deleteSemestre(Long id) {
        semestreRepository.deleteById(id);
    }
}
