package com.example.studentsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "module_filiere")
public class ModuleFiliere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    public ModuleFiliere() {
    }

    public ModuleFiliere(Filiere filiere, Module module) {
        this.filiere = filiere;
        this.module = module;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
