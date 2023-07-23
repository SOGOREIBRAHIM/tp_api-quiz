package com.api_quiz.api.web;

import com.api_quiz.api.entites.Quiz;
import com.api_quiz.api.entites.User;
import com.api_quiz.api.repository.IQuizRepository;
import com.api_quiz.api.services.IQuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuizController {

    private IQuizService quizService;

    //    methode creation de Quiz
    @PostMapping("/ajouterQuiz")
    private Quiz ajouter(@RequestBody Quiz quiz){
        return quizService.creerQuiz(quiz);
    }

    // afficher tous les quiz
    @GetMapping("/listQuiz")
    private List<Quiz> findAll(){
        return quizService.afficherQuizAll();
    }

    // afficher quiz par nom
    @GetMapping("/listQuizByNom")
    private Quiz findByNom(@RequestParam String nom){
        return quizService.afficherParNom(nom);
    }

//    supprimer quiz par nom
    @GetMapping("/supprimerQuiz")
    private String supprimerQuiz(@RequestParam String nom){
        quizService.supprimerQuizParNom(nom);
        return "Quiz supprimer";
    }

//    modifier quiz
    @PostMapping("/modifierQuiz")
    private Quiz modifierQuiz(@RequestBody Quiz quiz){
        return quizService.modifierQuiz(quiz);
    }
}
