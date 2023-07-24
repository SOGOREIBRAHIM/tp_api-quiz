package com.api_quiz.api.web;

import com.api_quiz.api.entites.Quiz;
import com.api_quiz.api.entites.User;
import com.api_quiz.api.repository.IUserRepository;
import com.api_quiz.api.services.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

//    Injection des interfaces
    private IUserRepository userRepository;
    private IUserService userService;

//    methode inscription de user
    @PostMapping("/ajouterUser")
    private User inscrire(@RequestBody User user){
       return userService.inscrire(user);
    }

//    methode connexion de user
    @PostMapping("/connecter")
    private User connecter(@RequestParam("user") String username, @RequestParam("pass") String password){
        return userService.connecter(username,password);
    }

//    methode pour modifier
    @PostMapping("/modifierUser")
    private User modifier(@RequestBody User user){
        if (user==null) throw new RuntimeException("Remplissez les champs vite");
        return userService.modifierUser(user);

    }

//    methode supprimer user
    @GetMapping("/supprimer")
    private String supprimer(@RequestParam String username){
        if (username==null) throw new RuntimeException("Choisissez un user");
        userService.supprimer(username);
        return "User supprimer avec succes";
    }

//    methode afficher list de tous users
    @GetMapping("/listeUser")
    private List<User> userList(){
        return userService.userList();
    }

//    methode afficher user par username
    @GetMapping("/listeUserParNom")
    private User userList(@RequestParam String usermane){
        return userService.afficherUserParUsername(usermane);
    }

    //    methode afficher user par id
    @GetMapping("/listeAllUser")
    private ResponseEntity<User> userAllList(@RequestParam String id){
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }



}
