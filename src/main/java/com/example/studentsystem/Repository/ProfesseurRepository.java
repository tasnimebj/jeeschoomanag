package com.example.studentsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentsystem.model.Professeur;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire, comme findByNomUtilisateur
    Professeur findByUsername(String nomUtilisateur);
}
