package com.example.studentsystem.Service;

import com.example.studentsystem.model.ElementModule;
import com.example.studentsystem.Repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementService {

    @Autowired
    private ElementRepository elementRepository;

    // Get all elements
    public List<ElementModule> getAllElements() {
        return elementRepository.findAll();
    }

    // Get element by ID
    public Optional<ElementModule> getElementById(Long id) {
        return elementRepository.findById(id);
    }

    // Create a new element
    public ElementModule createElement(ElementModule element) {

        return elementRepository.save(element);
    }

    // Update an existing element
    public ElementModule updateElement(Long id, ElementModule element) {
        if (elementRepository.existsById(id)) {
            element.setIdElement(id);
            return elementRepository.save(element);
        }
        return null; // or throw exception
    }

    // Delete an element
    public boolean deleteElement(Long id) {
        if (elementRepository.existsById(id)) {
            elementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
