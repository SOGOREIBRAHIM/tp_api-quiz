package com.api_quiz.api.web;

import com.api_quiz.api.entites.Question;
import com.api_quiz.api.repository.IQuestionRepository;
import com.api_quiz.api.services.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuestionController {

    private IQuestionRepository questionRepository;

    @GetMapping("/save")
    private Question save(Question question){
        return questionRepository.save(question);
    }

    @GetMapping("/question")
    private List<Question> afficher(){
        return questionRepository.findAll();
    }


}
