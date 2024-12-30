package com.example.studentsystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentsystem.model.ModaliteEvaluation;
import com.example.studentsystem.Repository.ModaliteEvaluationRepository;

@Service
public class ModaliteEvaluationService {

    @Autowired
    private ModaliteEvaluationRepository modaliteEvaluationRepository;

    // Récupérer toutes les modalités d'évaluation
    public List<ModaliteEvaluation> getAllModalites() {
        return modaliteEvaluationRepository.findAll();
    }

    // Récupérer une modalité d'évaluation par ID
    public Optional<ModaliteEvaluation> getModaliteById(Long id) {
        return modaliteEvaluationRepository.findById(id);
    }

    // Ajouter ou mettre à jour une modalité d'évaluation
    public ModaliteEvaluation saveOrUpdateModalite(ModaliteEvaluation modalite) {
        return modaliteEvaluationRepository.save(modalite);
    }

    // Supprimer une modalité d'évaluation par ID
    public void deleteModalite(Long id) {
        modaliteEvaluationRepository.deleteById(id);
    }

    // Récupérer une modalité d'évaluation par type
    public ModaliteEvaluation getModaliteByType(String typeModalite) {
        return modaliteEvaluationRepository.findByTypeModalite(typeModalite);
    }
    public ModaliteEvaluation update(Long id, ModaliteEvaluation evaluationMode) {
        Optional<ModaliteEvaluation> existingModalite = modaliteEvaluationRepository.findById(id);

        if (existingModalite.isPresent()) {
            ModaliteEvaluation modalite = existingModalite.get();
            modalite.setTypeModalite(evaluationMode.getTypeModalite());
            modalite.setCoefficient(evaluationMode.getCoefficient());
            // Other fields can be updated similarly if needed

            return modaliteEvaluationRepository.save(modalite);
        } else {
            return null; // Or handle this case more appropriately
        }
    }

}
