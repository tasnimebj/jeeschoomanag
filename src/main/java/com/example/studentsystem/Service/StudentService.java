package com.example.studentsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentsystem.model.Etudiant;
import com.example.studentsystem.Repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Retrieve all students
    public List<Etudiant> getAllEtudiants() {
        return studentRepository.findAll();
    }

    // Retrieve students by filiere ID
    public List<Etudiant> getEtudiantsByFiliere(Long filiereId) {
        return studentRepository.findByFiliereId(filiereId);
    }

    // Add a new student
    public Etudiant addEtudiant(Etudiant newEtudiant) {
        return studentRepository.save(newEtudiant);
    }

    // Update an existing student
    public Etudiant updateEtudiant(Long id, Etudiant updatedEtudiant) {
        Optional<Etudiant> existingEtudiant = studentRepository.findById(id);
        if (existingEtudiant.isPresent()) {
            Etudiant etudiant = existingEtudiant.get();
            etudiant.setNomEtudiant(updatedEtudiant.getNomEtudiant());
            etudiant.setPrenomEtudiant(updatedEtudiant.getPrenomEtudiant());
            etudiant.setFiliere(updatedEtudiant.getFiliere());
            etudiant.setSemestre(updatedEtudiant.getSemestre());
            etudiant.setNotes(updatedEtudiant.getNotes());
            return studentRepository.save(etudiant);
        }
        return null;
    }

    // Delete a student
    public void deleteEtudiant(Long id) {
        studentRepository.deleteById(id);
    }
}
