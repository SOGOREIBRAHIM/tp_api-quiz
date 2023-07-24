package com.api_quiz.api.services;

import com.api_quiz.api.entites.Question;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IQuestionService {

    List<Question> getAllQuestions();

    //Optional<Question> getQuestionById(Long idQuestion);

    Question ajouterQuestion(Question question);

    //Question modifierQuestion(Question question);

   String supprimerQuestion(Long idQuestion);

}
