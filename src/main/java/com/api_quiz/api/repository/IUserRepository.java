package com.api_quiz.api.repository;

import com.api_quiz.api.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IUserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);      // cgercher un user par son username
}
