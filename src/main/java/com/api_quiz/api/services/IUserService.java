package com.api_quiz.api.services;


import com.api_quiz.api.entites.User;


import java.util.List;


public interface IUserService {

    User inscrire(User user);   // inscription de User

    User connecter(String username, String password);   // connexion de User


    User modifierUser(User user);    // modifier un User

    void supprimer(String username);      // supprimer User par username qui est unique

    List<User> userList();      //  liste d'utilisateur

    User afficherUserParUsername(String username);






}
