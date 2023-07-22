package com.api_quiz.api.repository;

import com.api_quiz.api.entites.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuizRepository extends JpaRepository<Quiz,String> {
    Quiz findByNom(String nom);   // chercher un user par son username
}
