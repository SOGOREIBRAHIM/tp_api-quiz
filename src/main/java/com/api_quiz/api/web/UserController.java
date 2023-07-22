package com.api_quiz.api.web;

import com.api_quiz.api.entites.User;
import com.api_quiz.api.repository.IUserRepository;
import com.api_quiz.api.services.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

//    Injection des interfaces
    private IUserRepository userRepository;
    private IUserService userService;

//    methode inscription de user
    @PostMapping("/ajouter")
    private User inscrire(@RequestBody User user){
       return userService.inscrire(user);
    }

//    methode connexion de user
    @PostMapping("/connecter")
    private User connecter(@RequestParam("user") String username, @RequestParam("pass") String password){
        return userService.connecter(username,password);
    }

}
