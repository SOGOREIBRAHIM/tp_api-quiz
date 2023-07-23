package com.api_quiz.api.services;

import com.api_quiz.api.entites.Quiz;

import java.util.List;

public interface IQuizService {

    Quiz creerQuiz(Quiz quiz);      // creer un quiz

    List<Quiz> afficherQuizAll();     // afficher un Quiz

    Quiz afficherParNom(String nom);     // afficher un Quiz par nom

    String supprimerQuizParNom(String nom);     // supprimer un quiz

    Quiz modifierQuiz(Quiz quiz);   //modifier quiz


}
