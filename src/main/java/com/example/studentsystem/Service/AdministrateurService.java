package com.example.studentsystem.Service;

import com.example.studentsystem.Repository.AdministrateurRepository;
import com.example.studentsystem.model.Administrateur;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
@Service
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository adminRepository;

    public ResponseEntity<String> saveAdministrateur(String nomUtilisateur, String motDePasse) {
        Optional<Administrateur> existingAdmin = adminRepository.findByNomUtilisateur(nomUtilisateur);
        if (existingAdmin.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Nom d'utilisateur déjà existant.");
        }

        Administrateur admin = new Administrateur();
        admin.setNomUtilisateur(nomUtilisateur);
        admin.setMotDePasse(motDePasse);

        adminRepository.save(admin);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Administrateur créé avec succès.");
    }

    public ResponseEntity<Map<String, String>> validateAdmin(Administrateur admin) {
        Optional<Administrateur> existingAdmin = adminRepository.findByNomUtilisateur(admin.getNomUtilisateur());

        if (existingAdmin.isPresent() && existingAdmin.get().getMotDePasse().equals(admin.getMotDePasse())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "message", "Login successful!",
                    "username", existingAdmin.get().getNomUtilisateur()
            ));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                "message", "Invalid username or password."
        ));
    }

    @Transactional
    public void updateAdministrateur(Long adminId, String nomUtilisateur, String motDePasse) {
        Administrateur admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalStateException("Admin with ID " + adminId + " doesn't exist"));

        if (nomUtilisateur != null && !nomUtilisateur.isEmpty()) {
            admin.setNomUtilisateur(nomUtilisateur);
        }
        if (motDePasse != null && !motDePasse.isEmpty()) {
            admin.setMotDePasse(motDePasse);
        }

        adminRepository.save(admin);
    }
}
