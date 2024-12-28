package com.example.studentsystem.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.studentsystem.model.Administrateur;
import com.example.studentsystem.Service.AdministrateurService;
@RestController
@RequestMapping(path="/Administrateur")
public class AdministrateurController {

    @Autowired
    private AdministrateurService adminService;

    @PostMapping("/Administrateur/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Administrateur administrateur) {
        return adminService.validateAdmin(administrateur);
    }

    @PostMapping(path="Add")
    public ResponseEntity<String> addNewAdmin(@RequestParam("username") String nomUtilisateur,
                                              @RequestParam("password") String motDePasse) {
        return this.adminService.saveAdministrateur(nomUtilisateur, motDePasse);
    }

    @PutMapping(path="Update/{AdminId}")
    public void updateAdministrateur(@PathVariable("AdminId") Long adminId,
                                     @RequestParam(required = false) String nomUtilisateur,
                                     @RequestParam(required = false) String motDePasse) {
        this.adminService.updateAdministrateur(adminId, nomUtilisateur, motDePasse);
    }
}
