package com.example.studentsystem.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.studentsystem.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    @Query("SELECT m FROM Module m WHERE m.nomModule = :nomModule AND m.filiere.id = :filiereId AND m.semestre.id = :semestreId")
    Optional<Module> findByNomModuleAndFiliereIdAndSemestreId(
            @Param("nomModule") String nomModule,
            @Param("filiereId") Long filiereId,
            @Param("semestreId") Long semestreId
    );
}
