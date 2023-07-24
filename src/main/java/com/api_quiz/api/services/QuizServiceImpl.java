package com.api_quiz.api.services;

import com.api_quiz.api.entites.EnumDomaine;
import com.api_quiz.api.entites.Quiz;
import com.api_quiz.api.entites.EnumType;
import com.api_quiz.api.repository.IQuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
//@Transactional
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
        quiz.setDomaine(EnumDomaine.JAVA);
        quiz.setDureeTotal(new Date());
        quiz.setType(EnumType.NOUVEAU);
        return quizRepository.save(quiz);
    }

    // afficher tous les Quiz
    @Override
    public List<Quiz> afficherQuizAll() {
        return quizRepository.findAll();
    }

//    afficher quiz par nom
    @Override
    public Quiz afficherParNom(String nom) {
        return quizRepository.findByNom(nom);
    }

//   supprimer quiz par nom
    @Override
    public String supprimerQuizParNom(String nom) {
        return quizRepository.deleteAllByNom(nom);
    }


    @Override
    public Quiz modifierQuiz(Quiz quiz) {
        quiz.setIdQuiz(UUID.randomUUID().toString());
        quiz.setDomaine(EnumDomaine.JAVASCRIPT);
        quiz.setDureeTotal(new Date());
        quiz.setType(EnumType.EXISTANT);
        return  quizRepository.save(quiz);
    }
}
