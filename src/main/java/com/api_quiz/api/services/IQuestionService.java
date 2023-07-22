package com.api_quiz.api.services;
import com.api_quiz.api.entites.Question;
import com.api_quiz.api.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IQuestionService {
    public class QuestionService {

        private final IQuestionRepository questionRepository;

        @Autowired
        public QuestionService(IQuestionRepository questionRepository) {
            this.questionRepository = questionRepository;
        }

        public List<Question> getAllQuestions() {
            return questionRepository.findAll();
        } // Récupérer toutes les questions depuis la base de données

        public Question getQuestionById(Long id) {
            return questionRepository.findById(id).orElse(null);
        } // Récupérer une question par son identifiant

        public Question saveQuestion(Question question) {
            return questionRepository.save(question);
        }  // Sauvegarder une nouvelle question dans la base de données

        public void deleteQuestionById(Long id) {
            questionRepository.deleteById(id);
        }  // Supprimer une question par son identifiant

    }
}



