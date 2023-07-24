package com.api_quiz.api.services;

import com.api_quiz.api.entites.EnumNiveau;
import com.api_quiz.api.entites.Question;
import com.api_quiz.api.repository.IQuestionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional
@AllArgsConstructor
public class QuestionServiceImpl implements IQuestionService {

    private IQuestionRepository questionRepository;



    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

//    @Override
//    public Optional<Question> getQuestionById(Long idQuestion) {
//        return questionRepository.findById(idQuestion);
//    }
    // Ajout de la question
    @Override
    public Question ajouterQuestion(Question question) {
        question.setNiveau(EnumNiveau.FACILE);
        question.setTempsQuestion(new Date());
        return questionRepository.save(question);
    }
    /*// Mise à jour de la question
    @Override
    public Question modifierQuestion(Question question) {
        return questionRepository.save(question);
    }*/

    // Suppression de la question
    @Override
    public String supprimerQuestion(Long idQuestion) {
        questionRepository.deleteById(idQuestion);
        return "Question supprimer";

    }
}
