package com.api_quiz.api.repository;

import com.api_quiz.api.entites.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<Question,Long> {

}
