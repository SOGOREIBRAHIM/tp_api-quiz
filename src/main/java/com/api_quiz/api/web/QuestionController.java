package com.api_quiz.api.web;

import com.api_quiz.api.entites.Question;
import com.api_quiz.api.entites.Reponse;
import com.api_quiz.api.services.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
//@RequestMapping("/question")
public class QuestionController {

    private final IQuestionService questionService;

    // méthodes de CRUD

    // Endpoint pour récupérer toutes les questions
    @GetMapping("/listeQuestion")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // Endpoint pour récupérer une question par son ID
   /* @GetMapping("/{idQuestion}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long idQuestion) {
        return questionService.getQuestionById(idQuestion)
                .map(question -> new ResponseEntity<>(question, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }*/

    // Endpoint pour ajouter une nouvelle question
    @PostMapping("/ajouterQuestion")
    public Question ajouterQuestion(@RequestBody Question question) {
        return questionService.ajouterQuestion(question);
    }

    // Endpoint pour mettre à jour une question existante
//    @PutMapping("/{idQuestion}")
//    public ResponseEntity<Question> modifierQuestion(@PathVariable Long idQuestion, @RequestBody Question question) {
//        return questionService.getQuestionById(idQuestion)
//                .map(existingQuestion -> {
//                    question.setIdQuestion(idQuestion);
//                    Question updatedQuestion = questionService.modifierQuestion(question);
//                    return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
//                })
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    // Endpoint pour supprimer une question par son ID
    @GetMapping("/idQuestion")
    public String supprimerQuestion(@RequestParam Long idQuestion) {
        questionService.supprimerQuestion(idQuestion);
        return "Supprimer question !";
    }


}
