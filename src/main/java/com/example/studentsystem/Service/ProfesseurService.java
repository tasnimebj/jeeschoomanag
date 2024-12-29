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
        // Hash the password before saving (optional but recommended)
        String hashedPassword = hashPassword(newProfesseur.getPassword());
        newProfesseur.setPassword(hashedPassword);
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
            prof.setPassword(updatedProfesseur.getPassword()); // Update password
            return professeurRepository.save(prof);
        }
        return null;
    }
    public void deleteProfesseur(String code) {
        professeurRepository.deleteById(Long.valueOf(code));
    }
    // Helper method to hash the password
    private String hashPassword(String password) {
        // Use a proper hashing mechanism (e.g., BCrypt)
        return password;  // For simplicity, this is just a placeholder
    }
}





