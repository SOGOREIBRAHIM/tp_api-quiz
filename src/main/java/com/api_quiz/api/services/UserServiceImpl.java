package com.api_quiz.api.services;

import com.api_quiz.api.entites.User;
import com.api_quiz.api.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
//@Transactional
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



    //    methode modifier user
    @Override
    public User modifierUser(User user) {
        user.setIdUser(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    // methode suppression user
    @Override
    public void supprimer(String username) {
        userRepository.deleteByUsername(username);
    }

    /**
     * @return
     */
    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    /**
     * @param username
     * @return
     */
    @Override
    public User afficherUserParUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User getById(String id) {
        return userRepository.findById(id).get();
    }


}
