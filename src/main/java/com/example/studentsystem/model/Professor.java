package com.example.studentsystem.model;
import jakarta.persistence.*;
@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;

    private String professorFname;
    private String professorLname;
    private String codeProfessor;
    private String specialty;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Getters and setters
    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
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
