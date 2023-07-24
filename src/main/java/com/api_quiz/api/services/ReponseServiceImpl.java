package com.api_quiz.api.services;

import com.api_quiz.api.repository.IReponseRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@Transactional
@AllArgsConstructor
public class ReponseServiceImpl {

    private IReponseRepository reponseRepository;

}
