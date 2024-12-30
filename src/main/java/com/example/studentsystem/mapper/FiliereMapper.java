package com.example.studentsystem.mapper;

import com.example.studentsystem.dto.FiliereDTO;
import com.example.studentsystem.model.Filiere;
import org.springframework.stereotype.Component;

@Component
public class FiliereMapper {

    public FiliereDTO toDTO(Filiere filiere) {
        return new FiliereDTO(filiere.getId(), filiere.getNomFiliere());
    }

    public Filiere toEntity(FiliereDTO filiereDTO) {
        Filiere filiere = new Filiere();
        filiere.setId(filiereDTO.getId());
        filiere.setNomFiliere(filiereDTO.getNomFiliere());
        return filiere;
    }
}
