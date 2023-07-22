package com.api_quiz.api.services;

import com.api_quiz.api.entites.Reponse;
import com.api_quiz.api.repository.IReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

public interface IReponseService {
    @Service
    public class ReponseService {

        private final IReponseRepository reponseRepository;

        @Autowired
        public ReponseService(IReponseRepository reponseRepository) {
            this.reponseRepository = reponseRepository;
        }

        // Récupérer toutes les réponses depuis la base de données
        public List<Reponse> getAllReponses() {
            return reponseRepository.findAll();
        }

        // Récupérer une réponse par son identifiant
        public Reponse getReponseById(Long id) {
            return reponseRepository.findById(id).orElse(null);
        }

        // Sauvegarder une nouvelle réponse dans la base de données
        public Reponse saveReponse(Reponse reponse) {
            return reponseRepository.save(reponse);
        }

        // Supprimer une réponse par son identifiant
        public void deleteReponseById(Long id) {
            reponseRepository.deleteById(id);
        }
    }


}
