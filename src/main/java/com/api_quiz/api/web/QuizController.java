package com.api_quiz.api.web;

import com.api_quiz.api.entites.Quiz;
import com.api_quiz.api.entites.User;
import com.api_quiz.api.repository.IQuizRepository;
import com.api_quiz.api.services.IQuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class QuizController {

    private IQuizService quizService;

    //    methode creation de Quiz
    @PostMapping("/ajouterQuiz")
    private Quiz ajouter(@RequestBody Quiz quiz){
        return quizService.creerQuiz(quiz);
    }

}
