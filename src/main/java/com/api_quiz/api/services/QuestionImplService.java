package com.api_quiz.api.services;

import com.api_quiz.api.entites.Question;
import com.api_quiz.api.repository.IQuestionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class QuestionImplService implements IQuestionService{

    private IQuestionRepository questionRepository;
    @Override
    public Question creerQuestion(Question question) {
       question.setIdQuestion(UUID.randomUUID().toString());
        return questionRepository.save(question);
    }
}
