package com.api_quiz.api.services;

import com.api_quiz.api.entites.Quiz;
import com.api_quiz.api.entites.User;
import lombok.NoArgsConstructor;


public interface IUserService {

    User inscrire(User user);   // inscription de User
    User connecter(String username, String password);   // connexion de User
    Quiz creerQuiz(Quiz quiz);      // creer un quiz
    Quiz afficherQuiz(Long id);     // modifier Quiz par id qui est unique
    void attribuerQuizUser(Quiz quiz, User user);    // attribuer un quiz a un user
    void supprimerQuiz(String usermane);    // supprimer User par username qui est unique
    User afficherQuiz(String usermane);     // afficher User par username qui est unique
    Quiz modifierQuiz(String username);     // modifier User par username qui est unique

}
