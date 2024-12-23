package com.example.studentsystem.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;  // Changed to Long for consistency

    @Version
    private Long version;  // Version field for optimistic locking
    private String professorFname;
    private String professorLname;
    private String codeProfessor;
    private String specialty;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Professor() {}

    // Constructor with all arguments
    @JsonCreator
    public Professor(@JsonProperty("professorId") Long professorId,
                     @JsonProperty("professorFname") String professorFname,
                     @JsonProperty("professorLname") String professorLname,
                     @JsonProperty("codeProfessor") String codeProfessor,
                     @JsonProperty("specialty") String specialty,
                     @JsonProperty("user") User user) {
        this.professorId = professorId;
        this.professorFname = professorFname;
        this.professorLname = professorLname;
        this.codeProfessor = codeProfessor;
        this.specialty = specialty;
        this.user = user;
    }

    // Getters and Setters
    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public String getProfessorFname() {
        return professorFname;
    }

    public void setProfessorFname(String professorFname) {
        this.professorFname = professorFname;
    }

    public String getProfessorLname() {
        return professorLname;
    }

    public void setProfessorLname(String professorLname) {
        this.professorLname = professorLname;
    }

    public String getCodeProfessor() {
        return codeProfessor;
    }

    public void setCodeProfessor(String codeProfessor) {
        this.codeProfessor = codeProfessor;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
