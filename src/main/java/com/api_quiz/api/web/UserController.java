package com.api_quiz.api.web;

import com.api_quiz.api.entites.User;
import com.api_quiz.api.repository.IUserRepository;
import com.api_quiz.api.services.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
//    Injection des interfaces
    private IUserRepository userRepository;
    private IUserService userService;
//    methode inscription
    @PostMapping("/inscrire")
    private User connecter(@RequestBody User user){
       return userService.inscrire(user);
    }
}
