package com.api_quiz.api.services;

import com.api_quiz.api.entites.Reponse;
import com.api_quiz.api.repository.IReponseRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@Transactional
@AllArgsConstructor
public class ReponseServiceImpl implements IReponseService{

    private IReponseRepository reponseRepository;


}
