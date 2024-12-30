package com.example.studentsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentsystem.model.Etudiant;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Etudiant, Long> {
    // Custom query to find students by filiere ID
    List<Etudiant> findByFiliereId(Long filiereId);
}
