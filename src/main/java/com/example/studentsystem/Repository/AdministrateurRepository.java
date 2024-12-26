package com.example.studentsystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.studentsystem.model.Administrateur;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {
    Optional<Administrateur> findByNomUtilisateur(String username);
}