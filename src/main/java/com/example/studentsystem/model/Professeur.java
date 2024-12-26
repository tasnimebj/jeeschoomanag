package com.example.studentsystem.model;

import java.util.List;

import jakarta.persistence.Column;
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
    private Long code;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String image;
    private String specialite;

    @OneToMany(mappedBy = "professeur")
    private List<ElementModule> elements;

    public Professeur(Long code, String nom, String prenom, String username, String password, String image,
                      String specialite, List<ElementModule> elements) {
        super();
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.image = image;
        this.specialite = specialite;
        this.elements = elements;
    }

    public Professeur(String nom, String prenom, String username, String password, String image, String specialite,
                      List<ElementModule> elements) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.image = image;
        this.specialite = specialite;
        this.elements = elements;
    }

    public Professeur(String nom, String prenom, String username, String password, String image, String specialite) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.image = image;
        this.specialite = specialite;
    }

    public Professeur() {
        super();
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<ElementModule> getElements() {
        return elements;
    }

    public void setElements(List<ElementModule> elements) {
        this.elements = elements;
    }






}