package com.example.studentsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity

public class NoteElement {


    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name="element_id")
        @JsonBackReference  // Prevents infinite recursion by not serializing the 'Filiere' object in 'Module'

        private ElementModule element;

        @ManyToOne
        @JoinColumn(name="etudiant_id")
        @JsonBackReference  // Prevents infinite recursion by not serializing the 'Filiere' object in 'Module'

        private Etudiant etudiant;

        private double noteElement;

        @ManyToOne
        @JoinColumn(name="modalite_id")
        @JsonBackReference

        private ModaliteEvaluation modalite;



        public NoteElement() {
            // TODO Auto-generated constructor stub
        }



        public NoteElement(Long id, ElementModule element, Etudiant etudiant, double noteElement, ModaliteEvaluation modalite) {
            this.id = id;
            this.element = element;
            this.etudiant = etudiant;
            this.noteElement = noteElement;
            this.modalite = modalite;
        }



        public Long getId() {
            return id;
        }



        public void setId(Long id) {
            this.id = id;
        }



        public ElementModule getElement() {
            return element;
        }



        public void setElement(ElementModule element) {
            this.element = element;
        }



        public Etudiant getEtudiant() {
            return etudiant;
        }



        public void setEtudiant(Etudiant etudiant) {
            this.etudiant = etudiant;
        }



        public double getNoteElement() {
            return noteElement;
        }



        public void setNoteElement(double noteElement) {
            this.noteElement = noteElement;
        }



        public ModaliteEvaluation getModalite() {
            return modalite;
        }



        public void setModalite(ModaliteEvaluation modalite) {
            this.modalite = modalite;
        }



    }
