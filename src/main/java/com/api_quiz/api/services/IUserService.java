package com.api_quiz.api.services;

import com.api_quiz.api.entites.Quiz;
import com.api_quiz.api.entites.User;
import lombok.NoArgsConstructor;

import java.util.List;


public interface IUserService {

    User inscrire(User user);   // inscription de User

    User connecter(String username, String password);   // connexion de User

    User modifierQuiz(User user);    // modifier un User

    void supprimer(String username);      // supprimer User par username qui est unique






}
