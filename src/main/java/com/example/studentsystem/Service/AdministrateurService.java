package com.example.studentsystem.Service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;

import com.example.studentsystem.model.Administrateur;
import com.example.studentsystem.Repository.AdministrateurRepository;


@Service
public class AdministrateurService  {

    @Autowired
    private AdministrateurRepository AdminRepository;





    public AdministrateurService(AdministrateurRepository AdminRepository) {
        this.AdminRepository = AdminRepository;
    }

    //add admin
    public ResponseEntity<String> SaveAdministrateur(String nomUtilisateur, String motDePasse, MultipartFile imageFile) {
        try {

            // Vérifier si le nom d'utilisateur existe déjà
            Optional<Administrateur> existingAdmin = AdminRepository.findByNomUtilisateur(nomUtilisateur);
            if (existingAdmin.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Nom d'utilisateur déjà existant.");
            }

            String imagePath = null;

            // Sauvegarder l'image si fournie
            if (imageFile != null && !imageFile.isEmpty()) {
                imagePath = saveImage(imageFile);
            }

            // Créer l'entité Administrateur
            Administrateur admin = new Administrateur();
            admin.setNomUtilisateur(nomUtilisateur);
            admin.setMotDePasse(motDePasse); // Ideally, hash the password
            admin.setImage(imagePath);

            // Sauvegarder dans la base de données
            AdminRepository.save(admin);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Administrateur créé avec succès.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la sauvegarde de l'image : " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Une erreur inattendue est survenue : " + e.getMessage());
        }
    }


    //login validation
    public ResponseEntity<Map<String, String>> validateAdmin(Administrateur Admin) {
        Optional<Administrateur> admin = AdminRepository.findByNomUtilisateur(Admin.getNomUtilisateur());

        if (admin.isPresent() && admin.get().getMotDePasse().equals(Admin.getMotDePasse())) {
            // Réponse en cas de succès
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "message", "Login successful!",
                    "username", admin.get().getNomUtilisateur(),
                    "image", admin.get().getImage() != null ? admin.get().getImage() : "default_image_url_or_placeholder"
            ));

        }

        // Réponse en cas d'échec
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                "message", "Invalid username or password."
        ));
    }
    @Transactional
    public void UpdateAdministrateur(Long AdminId, String nomUtilisateur, String motDePasse, String image) {
        Administrateur admin = AdminRepository.findById(AdminId)
                .orElseThrow(() -> new IllegalStateException("Admin with ID " + AdminId + " doesn't exist"));

        if (nomUtilisateur != null && !nomUtilisateur.isEmpty() && !nomUtilisateur.equals(admin.getNomUtilisateur())) {
            admin.setNomUtilisateur(nomUtilisateur);
        }
        if (motDePasse != null && !motDePasse.isEmpty() && !motDePasse.equals(admin.getMotDePasse())) {
            admin.setMotDePasse(motDePasse);
        }
        if (image != null && !image.isEmpty() && !image.equals(admin.getImage())) {
            admin.setImage(image);
        }

        // Save updated admin
        AdminRepository.save(admin);



    }




    //save image

    public String saveImage(MultipartFile file) throws IOException {
        // Define the path to save the file
        String reactAppImageFolder = "C:\\Users\\user\\Desktop\\Mini_Projet_Java\\Mini_Projet_React_app\\react-app-project\\src\\Admin\\AdminImages";
        Path uploadPath = Paths.get(reactAppImageFolder);

        // Create the directory if it doesn't exist
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Save the file with a unique name
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Return the relative path to the image (to store in the database)
        return "Images/" + fileName;
    }





}