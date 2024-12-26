package com.example.studentsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentsystem.model.NoteElement;



@Repository
public interface NoteElementRepository extends JpaRepository<NoteElement, Long> {

}
