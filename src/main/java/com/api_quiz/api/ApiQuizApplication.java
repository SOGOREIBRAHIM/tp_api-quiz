package com.api_quiz.api;

import com.api_quiz.api.entites.NiveauEnum;
import com.api_quiz.api.entites.Question;
import com.api_quiz.api.entites.User;
import com.api_quiz.api.repository.IUserRepository;
import com.api_quiz.api.services.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class ApiQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiQuizApplication.class, args);
	}
//	@Bean
//	CommandLineRunner start(IUserService userService){
//		return args -> {
//			try {
//				User user = new User();
//				user.setIdUser(null);
//				user.setNom("Sogore");
//				user.setPrenom("Ibrahim");
//				user.setEmail("sogore@gmail.com");
//				user.setUsername("user");
//				user.setPassword("12345678");
//				userService.inscrire(user);
//			}catch (Exception e){
//				e.printStackTrace();
//			}
//
//		};
//	}

}
