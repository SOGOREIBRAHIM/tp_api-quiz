package com.api_quiz.api.services;

import com.api_quiz.api.entites.DomaineEnum;
import com.api_quiz.api.entites.Quiz;
import com.api_quiz.api.entites.TypeEnum;
import com.api_quiz.api.entites.User;
import com.api_quiz.api.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

//    Les injections
    private IUserRepository userRepository;


//    methode inscrire user
    @Override
    public User inscrire(User user) {
        user.setIdUser(UUID.randomUUID().toString());       // permet de generer String en fonction de heure system
        if (user==null) throw new RuntimeException("Remplissez les champs vides");
            return userRepository.save(user);
         }

//    methode connecter user
    @Override
    public User connecter(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new RuntimeException("Remplissez les champs vides");
        if (user.getPassword().equals(password)) {
            return user;
        }
            throw new RuntimeException("Authentification echoue");
    }

//    methode supprimer user
    @Override
    public User modifierQuiz(User user) {
       return userRepository.save(user);
    }

    /**
     * @param username
     */
    @Override
    public void supprimer(String username) {
        userRepository.deleteById(username);
    }


}
