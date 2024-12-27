package com.example.studentsystem.Service;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.studentsystem.model.Module;
import com.example.studentsystem.Repository.ModuleRepository;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    // Create or Update a Module
    @Transactional

    public ResponseEntity<Module> saveModule(Module module) {
        Optional<Module> existantModul=moduleRepository.findByNomModuleAndFiliereIdAndSemestreId(module.getNomModule(),
                module.getFiliere().getId(),module.getSemestre().getId());
        if(existantModul.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(existantModul.get());
        }
        moduleRepository.save(module);
        return ResponseEntity.status(HttpStatus.CREATED).body(module);
    }

    // Retrieve all Modules
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    // Retrieve a Module by ID
    public Module getModuleById(Long id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
    }

    // Delete a Module by ID
    @Transactional

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}

