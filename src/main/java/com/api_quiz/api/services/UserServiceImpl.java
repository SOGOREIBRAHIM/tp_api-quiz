package com.api_quiz.api.services;

import com.api_quiz.api.entites.Quiz;
import com.api_quiz.api.entites.User;
import com.api_quiz.api.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

//    Les injections
    private IUserRepository userRepository;
    private IQuizRepository quizRepository;
    private IQuestionRepository questionRepository;
    private IReponseRepository reponseRepository;
    private IResultatRepository resultatRepository;


//    methode inscrire
    @Override
    public User inscrire(User user) {
        user.setIdUser(UUID.randomUUID().toString());       // permet de generer String en fonction de heure system
        if (user==null) throw new RuntimeException("Remplissez les champs vides");
            return userRepository.save(user);
         }


    /**
     * @param username
     * @param password
     */

//    methode connecter
    @Override
    public User connecter(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new RuntimeException("Remplissez les champs vides");
        if (user.getPassword().equals(password)) {
            return user;
        }
            throw new RuntimeException("Authentification echoue");
    }
    /**
     * @param quiz
     * @return
     */
//    Creation de Quiz par un user
    @Override
    public Quiz creerQuiz(Quiz quiz) {
        quiz.setIdQuiz(UUID.randomUUID().toString());
        if (quiz==null) throw  new RuntimeException("Champs vide");
        return quizRepository.save(quiz);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Quiz afficherQuiz(Long id) {
        return null;
    }

    /**
     * @param quiz
     * @param user
     */
    @Override
    public void attribuerQuizUser(Quiz quiz, User user) {

    }

    /**
     * @param usermane
     */
    @Override
    public void supprimerQuiz(String usermane) {

    }

    /**
     * @param usermane
     * @return
     */
    @Override
    public User afficherQuiz(String usermane) {
        return null;
    }

    /**
     * @param username
     * @return
     */
    @Override
    public Quiz modifierQuiz(String username) {

        return null;
    }


}
