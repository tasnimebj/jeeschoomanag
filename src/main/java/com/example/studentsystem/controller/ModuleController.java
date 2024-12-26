package com.example.studentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentsystem.model.Module;
import com.example.studentsystem.Service.ModuleService;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    // Create a new Module
    @PostMapping("add")
    public ResponseEntity<Module> createModule(@RequestBody Module module) {
        return moduleService.saveModule(module);
    }

    // Retrieve all Modules
    @GetMapping("get")
    public ResponseEntity<List<Module>> getAllModules() {
        return ResponseEntity.ok(moduleService.getAllModules());
    }

    // Retrieve a single Module by ID
    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable Long id) {
        return ResponseEntity.ok(moduleService.getModuleById(id));
    }

    // Update a Module
    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module moduleDetails) {
        Module existingModule = moduleService.getModuleById(id);
        existingModule.setNomModule(moduleDetails.getNomModule());
        existingModule.setSemestre(moduleDetails.getSemestre());
        existingModule.setFiliere(moduleDetails.getFiliere());
        existingModule.setElements(moduleDetails.getElements());
        return moduleService.saveModule(existingModule);
    }

    // Delete a Module
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.ok("Module deleted successfully with id: " + id);
    }
}
