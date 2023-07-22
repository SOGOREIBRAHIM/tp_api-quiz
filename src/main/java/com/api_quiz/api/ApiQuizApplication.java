package com.api_quiz.api;

import com.api_quiz.api.entites.*;
import com.api_quiz.api.repository.IUserRepository;
import com.api_quiz.api.services.IQuizService;
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
	CommandLineRunner start(IUserService userService, IQuizService quizService){
		return args -> {
			try {
				User user = new User();
				user.setIdUser(null);
				user.setNom("Sogore");
				user.setPrenom("Ibrahim");
				user.setEmail("sogorei@gmail.com");
				user.setUsername("user");
				user.setPassword("12345678");
				userService.inscrire(user);



			}catch (Exception e){
				e.printStackTrace();
			}
			Quiz quiz = new Quiz();
			quiz.setIdQuiz(null);
			quiz.setNom("Questionbbbb anglais");
			quiz.setType(TypeEnum.NOUVEAU);
			quiz.setDureeTotal(new Date());
			quiz.setDomaine(DomaineEnum.JAVA);
			quiz.setCreerUser(new User("7b6fdee4-feb5-4bf5-966f-f08475fdbe60","Sogore","Ibrahim","sogorei@gmail.com","user","12345678",null,null,null,null,null));
			quizService.creerQuiz(quiz);

			try {
				User user1 = userService.connecter("user","12345678");
				System.out.println(user1.getIdUser());
				System.out.println(user1.getUsername());
			}catch (Exception e){
				e.printStackTrace();
			}

		};

	}

}
