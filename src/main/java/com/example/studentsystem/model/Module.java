package com.example.studentsystem.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeModule;
    private String nomModule;

    @ManyToOne

    @JoinColumn(name="semestre_id")
    @JsonBackReference  // Prevents infinite recursion by not serializing the 'Filiere' object in 'Module'

    private Semestre semestre;

    @ManyToOne

    @JoinColumn(name="filiere_id")
    @JsonBackReference("filiere-module")

    private Filiere filiere;

    @OneToMany(mappedBy = "module")
    @JsonManagedReference  // Ensures the list of ElementModules is serialized

    private List<Element> elements;



    public Module() {
        // TODO Auto-generated constructor stub
    }

    public Module(String nomModule, Semestre semestre, List<Element> elements, Filiere filiere) {
        this.nomModule = nomModule;
        this.semestre = semestre;
        this.elements = elements;
        this.filiere=filiere;
    }

    public Module(Long codeModule, String nomModule, Semestre semestre, List<Element> elements, Filiere filiere) {
        this.codeModule = codeModule;
        this.nomModule = nomModule;
        this.semestre = semestre;
        this.elements = elements;
        this.filiere=filiere;
    }



    public Module(Long codeModule, String nomModule) {
        super();
        this.codeModule = codeModule;
        this.nomModule = nomModule;
    }



    public Module(String nomModule) {
        super();
        this.nomModule = nomModule;
    }

    public Long getCodeModule() {
        return codeModule;
    }


    public void setCodeModule(Long codeModule) {
        this.codeModule = codeModule;
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }



}
