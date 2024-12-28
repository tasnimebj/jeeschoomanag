package com.example.studentsystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentsystem.model.Professeur;
import com.example.studentsystem.Repository.ProfesseurRepository;
@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    public Professeur addProfesseur(Professeur newProfesseur) {
        return professeurRepository.save(newProfesseur);
    }

    public Professeur updateProfesseur(String code, Professeur updatedProfesseur) {
        Optional<Professeur> existingProfesseur = professeurRepository.findById(Long.valueOf(code));
        if (existingProfesseur.isPresent()) {
            Professeur prof = existingProfesseur.get();
            prof.setNom(updatedProfesseur.getNom());
            prof.setPrenom(updatedProfesseur.getPrenom());
            prof.setUsername(updatedProfesseur.getUsername());
            prof.setSpecialite(updatedProfesseur.getSpecialite());
            return professeurRepository.save(prof);
        }
        return null;
    }

    public void deleteProfesseur(String code) {
        professeurRepository.deleteById(Long.valueOf(code));
    }
}





