package com.api_quiz.api.services;

import com.api_quiz.api.entites.Quiz;
import com.api_quiz.api.entites.User;
import com.api_quiz.api.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private IUserRepository userRepository;
    private IQuizRepository quizRepository;
    private IQuestionRepository questionRepository;
    private IReponseRepository reponseRepository;
    private IResultatRepository resultatRepository;



    @Override
    public User inscrire(User user) {
        user.setIdUser(UUID.randomUUID().toString());
        if (user==null) throw new RuntimeException("Remplissez les champs vides");
            return userRepository.save(user);
         }


    /**
     * @param username
     * @param password
     */
    @Override
    public User connecter(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) throw new RuntimeException("Remplissez les champs vides");
        if (user.getPassword().equals(password)) {
            return user;
        }
            throw new RuntimeException("Authentification echoue");
    }
    /**
     * @param quiz
     * @return
     */
    @Override
    public Quiz creerQuiz(Quiz quiz) {
        quiz.setIdQuiz(UUID.randomUUID().toString());
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
