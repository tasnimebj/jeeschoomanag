package com.example.studentsystem.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Professeur")
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;
    private String nom;
    private String prenom;
    private String username;
    private String specialite;

    @OneToMany(mappedBy = "professeur")
    private List<Element> elements;

    public Professeur(Long code, String nom, String prenom, String username,
                      String specialite, List<Element> elements) {
        super();
        this.code = String.valueOf(code);
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;

        this.specialite = specialite;
        this.elements = elements;
    }

    public Professeur(String nom, String prenom, String username,String specialite,
                      List<Element> elements) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;

        this.specialite = specialite;
        this.elements = elements;
    }

    public Professeur(String nom, String prenom, String username, String specialite) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;

        this.specialite = specialite;
    }

    public Professeur() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }}

