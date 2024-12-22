package com.example.studentsystem.service;

import com.example.studentsystem.model.Professor;
import com.example.studentsystem.model.User;
import com.example.studentsystem.repository.ProfessorRepository;
import com.example.studentsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private UserRepository userRepository; // Inject UserRepository

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Professor addProfessor(Professor professor) {
        // Check if the user exists
        User user = userRepository.findById(professor.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Set the user for the professor
        professor.setUser(user);

        // Save and return the professor
        return professorRepository.save(professor);
    }


    public Professor updateProfessor(int id, Professor professorDetails) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor not found"));
        professor.setProfessorFname(professorDetails.getProfessorFname());
        professor.setProfessorLname(professorDetails.getProfessorLname());
        professor.setCodeProfessor(professorDetails.getCodeProfessor());
        professor.setSpecialty(professorDetails.getSpecialty());
        return professorRepository.save(professor);
    }

    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Professor not found"));

        // Perform cleanup or checks if needed (e.g., detach from related entities)
        professorRepository.delete(professor);
    }

}
