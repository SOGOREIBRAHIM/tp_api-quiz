package com.api_quiz.api.services;

import com.api_quiz.api.entites.Quiz;

import java.util.List;

public interface IQuizService {

    Quiz creerQuiz(Quiz quiz);      // creer un quiz

    List<Quiz> afficherQuizAll();     // afficher un Quiz


}
