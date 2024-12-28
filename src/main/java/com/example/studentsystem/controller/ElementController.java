package com.example.studentsystem.controller;

import com.example.studentsystem.model.Element;
import com.example.studentsystem.Service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/elements")
public class ElementController {

    @Autowired
    private ElementService elementService;

    // Get all elements
    @GetMapping
    public List<Element> getAllElements() {
        return elementService.getAllElements();
    }

    // Get element by ID
    @GetMapping("/{id}")
    public ResponseEntity<Element> getElementById(@PathVariable Long id) {
        Optional<Element> element = elementService.getElementById(id);
        return element.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new element
    @PostMapping
    public ResponseEntity<Element> createElement(@RequestBody Element element) {
        Element createdElement = elementService.createElement(element);
        return new ResponseEntity<>(createdElement, HttpStatus.CREATED);
    }

    // Update an existing element
    @PutMapping("/{id}")
    public ResponseEntity<Element> updateElement(@PathVariable Long id, @RequestBody Element element) {
        Element updatedElement = elementService.updateElement(id, element);
        return updatedElement != null ? ResponseEntity.ok(updatedElement) : ResponseEntity.notFound().build();
    }

    // Delete an element
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElement(@PathVariable Long id) {
        return elementService.deleteElement(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
