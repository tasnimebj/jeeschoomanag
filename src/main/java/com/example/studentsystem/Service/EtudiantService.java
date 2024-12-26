package com.example.studentsystem.Service;

import com.example.studentsystem.model.Etudiant;
import com.example.studentsystem.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantByCode(Long code) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(code);

        return etudiant.orElse(null);
    }

    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(Long code, Etudiant updatedEtudiant) {
        if (etudiantRepository.existsById(code)) {
            updatedEtudiant.setCodeEtudiant(code);
            return etudiantRepository.save(updatedEtudiant);
        }
        return null;
    }

    public boolean deleteEtudiant(Long code) {
        if (etudiantRepository.existsById(code)) {
            etudiantRepository.deleteById(code);
            return true;
        }
        return false;
    }
}
