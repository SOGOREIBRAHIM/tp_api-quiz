package com.api_quiz.api.repository;

import com.api_quiz.api.entites.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultatRepository extends JpaRepository<Reponse,Long> {
}
