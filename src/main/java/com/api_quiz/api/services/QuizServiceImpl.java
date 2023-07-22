package com.api_quiz.api.services;

import com.api_quiz.api.entites.DomaineEnum;
import com.api_quiz.api.entites.Quiz;
import com.api_quiz.api.entites.TypeEnum;
import com.api_quiz.api.repository.IQuizRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class QuizServiceImpl implements IQuizService{
//    injection
    private IQuizRepository quizRepository;

    /**
     * @param quiz 
     * @return
     */
//    Creation de Quiz par un user
    @Override
    public Quiz creerQuiz( Quiz quiz) {
        quiz.setIdQuiz(UUID.randomUUID().toString());
        if (quiz==null) throw  new RuntimeException("Champs vide");
        quiz.setDomaine(DomaineEnum.JAVA);
        quiz.setDureeTotal(new Date());
        quiz.setType(TypeEnum.NOUVEAU);
        return quizRepository.save(quiz);
    }

    // User peut afficher Quiz
    @Override
    public List<Quiz> afficherQuizAll() {
        return quizRepository.findAll();
    }
}
