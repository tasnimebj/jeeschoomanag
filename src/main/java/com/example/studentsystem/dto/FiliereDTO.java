package com.example.studentsystem.dto;

public class FiliereDTO {
    private Long id;
    private String nomFiliere;

    public FiliereDTO() {}

    public FiliereDTO(Long id, String nomFiliere) {
        this.id = id;
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
}
