package com.example.studentsystem.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Creates separate tables for each subclass

public abstract class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer utilisateurId;

    @Column(nullable = false, length = 50)
    private String nomUtilisateur;

    @Column(nullable = false, length = 50)
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // Enum: admin or professeur

    // Getters and Setters
}

