package com.example.studentsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentsystem.model.Semestre;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
