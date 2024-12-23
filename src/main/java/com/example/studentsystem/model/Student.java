package com.example.studentsystem.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue

    private int student_id;
    private String student_Fname;
    private String student_Lname;
    private Boolean is_absent;
    private int branch_id;

}
