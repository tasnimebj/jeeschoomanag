package com.example.studentsystem.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
    private AdministrateurService AdminService;

    public AdministrateurController(AdministrateurService adminService) {
        this.AdminService = adminService;
    }
    @PostMapping("login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Administrateur administrateur) {
        return AdminService.validateAdmin(administrateur);
    }

    @PostMapping(path="Add")
    public ResponseEntity<String> addNewstudent( @RequestParam("username") String nomUtilisateur, @RequestParam("password") String motDePasse, @RequestParam(value = "image", required = false) MultipartFile imageFile) throws IOException {

        return this.AdminService.SaveAdministrateur(nomUtilisateur, motDePasse, imageFile);
    }

    @PutMapping(path="Update")
    public void UpdateAdministrateur(@PathVariable("AdminId") Long AdminId,@RequestParam(required=false) String nomUtilisateur, @RequestParam(required=false) String motDePasse,@RequestParam(required=false) String image) {
        this.AdminService.UpdateAdministrateur(AdminId,nomUtilisateur,motDePasse,image);

    }
}