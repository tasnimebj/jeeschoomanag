package com.example.studentsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentsystem.model.ModaliteEvaluation;

@Repository
public interface ModaliteEvaluationRepository extends JpaRepository<ModaliteEvaluation, Long> {
    // Méthode personnalisée si nécessaire (exemple : recherche par type de modalité)
    ModaliteEvaluation findByTypeModalite(String typeModalite);
}
