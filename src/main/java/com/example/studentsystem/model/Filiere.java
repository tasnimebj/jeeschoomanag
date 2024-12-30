package com.example.studentsystem.model;

import java.util.List;


import jakarta.persistence.*;

@Entity
@Table
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomFiliere;

    @OneToMany(mappedBy = "filiere")

    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "filiere")

    private List<Module> module;

    public Filiere() {
        // TODO Auto-generated constructor stub
    }

    public Filiere(Long id, String nomFiliere, List<Etudiant> etudiants, List<Module> module) {
        this.id = id;
        this.nomFiliere = nomFiliere;
        this.etudiants = etudiants;
        this.module = module;
    }

    public Filiere(String nomFiliere, List<Etudiant> etudiants, List<Module> module) {
        this.nomFiliere = nomFiliere;
        this.etudiants = etudiants;
        this.module = module;
    }



    public Filiere(Long id, String nomFiliere) {
        super();
        this.id = id;
        this.nomFiliere = nomFiliere;
    }



    public Filiere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<Module> getModule() {
        return module;
    }

    public void setModule(List<Module> module) {
        this.module = module;
    }



}
