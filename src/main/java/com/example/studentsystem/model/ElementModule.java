package com.example.studentsystem.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class ElementModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idElement;
    private String nomElement;
    private double coefficient;

    @ManyToOne
    @JoinColumn(name="module_id")
    private Module module;

    @ManyToOne
    @JoinColumn(name="professeur_id")
    private Professeur professeur;

    @OneToMany(mappedBy = "element")
    private List<NoteElement> notes;

    public ElementModule() {
    }

    public ElementModule(Long idElement, String nomElement, double coefficient, Module module, Professeur professeur,
                   List<NoteElement> notes) {
        this.idElement = idElement;
        this.nomElement = nomElement;
        this.coefficient = coefficient;
        this.module = module;
        this.professeur = professeur;
        this.notes = notes;
    }

    public ElementModule(String nomElement, double coefficient, Module module, Professeur professeur,
                   List<NoteElement> notes) {
        this.nomElement = nomElement;
        this.coefficient = coefficient;
        this.module = module;
        this.professeur = professeur;
        this.notes = notes;
    }


    public ElementModule(String nomElement, double coefficient) {
        super();
        this.nomElement = nomElement;
        this.coefficient = coefficient;
    }

    public Long getIdElement() {
        return idElement;
    }

    public void setIdElement(Long idElement) {
        this.idElement = idElement;
    }

    public String getNomElement() {
        return nomElement;
    }

    public void setNomElement(String nomElement) {
        this.nomElement = nomElement;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public List<NoteElement> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteElement> notes) {
        this.notes = notes;
    }








}
