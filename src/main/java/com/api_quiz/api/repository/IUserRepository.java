package com.api_quiz.api.repository;

import com.api_quiz.api.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IUserRepository extends JpaRepository<User,String> {

    User findByUsername(String username);      // chercher un user par son username
    void deleteByUsername(String username);      // supprimer un user par son username



}
