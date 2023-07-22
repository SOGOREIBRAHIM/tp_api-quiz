package com.api_quiz.api.services;

import com.api_quiz.api.repository.IResultatRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ResultatServiceImpl {

    private IResultatRepository resultatRepository;
}
