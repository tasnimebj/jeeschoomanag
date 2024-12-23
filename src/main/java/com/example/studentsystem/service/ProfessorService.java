package com.example.studentsystem.service;

import com.example.studentsystem.model.Professor;
import com.example.studentsystem.model.User;
import com.example.studentsystem.repository.ProfessorRepository;
import com.example.studentsystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    // Create a new professor
    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    // Get all professors
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    // Get a professor by ID
    public Optional<Professor> getProfessorById(int professorId) {
        return professorRepository.findById(professorId);
    }

    // Update an existing professor
    public Professor updateProfessor(int professorId, Professor professor) {
        if (professorRepository.existsById(professorId)) {
            professor.setProfessorId((long) professorId);
            return professorRepository.save(professor);
        } else {
            return null;
        }
    }

    // Delete a professor by ID
    public void deleteProfessor(int professorId) {
        professorRepository.deleteById(professorId);
    }
}
