package com.example.studentsystem.Service;
import com.example.studentsystem.dto.FiliereDTO;
import com.example.studentsystem.mapper.FiliereMapper;
import com.example.studentsystem.model.Filiere;
import com.example.studentsystem.Repository.FiliereRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiliereService {

    private final FiliereRepository filiereRepository;
    private final FiliereMapper filiereMapper;

    public FiliereService(FiliereRepository filiereRepository, FiliereMapper filiereMapper) {
        this.filiereRepository = filiereRepository;
        this.filiereMapper = filiereMapper;
    }

    public List<FiliereDTO> getAllFilieres() {
        List<Filiere> filieres = filiereRepository.findAll();
        return filieres.stream()
                .map(filiereMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Filiere createFiliere(FiliereDTO filiereDTO) {
        Filiere filiere = filiereMapper.toEntity(filiereDTO);
        return filiereRepository.save(filiere);
    }
    public void deleteFiliere(Long id) {
        // Check if the Filiere exists before trying to delete it
        if (!filiereRepository.existsById(id)) {
            throw new RuntimeException("Filiere not found with id: " + id);
        }

        // Delete the Filiere by id
        filiereRepository.deleteById(id);
    }
    public Filiere updateFiliere(Long id, FiliereDTO filiereDTO) {
        if (filiereRepository.existsById(id)) {
            Filiere filiere = filiereMapper.toEntity(filiereDTO);
            filiere.setId(id);
            return filiereRepository.save(filiere);
        }
        return null; // or throw an exception
    }
}
