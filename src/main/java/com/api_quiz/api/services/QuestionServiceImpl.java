package com.api_quiz.api.services;

import com.api_quiz.api.repository.IQuestionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class QuestionServiceImpl {

    private IQuestionRepository questionRepository;
}
