package com.api_quiz.api;

import com.api_quiz.api.entites.*;
import com.api_quiz.api.services.IQuizService;
import com.api_quiz.api.services.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

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

				User user2 = new User();
				user2.setIdUser(null);
				user2.setNom("Sogore1");
				user2.setPrenom("Ibrahim1");
				user2.setEmail("sogorei1@gmail.com");
				user2.setUsername("user1");
				user2.setPassword("12345678a");
				userService.inscrire(user2);

				User user1 = userService.connecter("user","12345678");
				System.out.println(user1.getIdUser());
				System.out.println(user1.getUsername());

				Quiz quiz = new Quiz();
				quiz.setIdQuiz(null);
				quiz.setNom("question bio");
				quiz.setType(EnumType.NOUVEAU);
				quiz.setDureeTotal(new Date());
				quiz.setDomaine(EnumDomaine.JAVASCRIPT);
				quiz.setCreerUser(new User("00c9f604-d68f-4438-b90b-7e745772ff87","Sogore","Ibrahim","sogorei@gmail.com","user","12345678",null,null,null,null,null));
				quizService.creerQuiz(quiz);

				Quiz quiz2 = new Quiz();
				quiz2.setIdQuiz(null);
				quiz2.setNom("Question anglais");
				quiz2.setType(EnumType.NOUVEAU);
				quiz2.setDureeTotal(new Date());
				quiz2.setDomaine(EnumDomaine.JAVA);
				quiz2.setCreerUser(new User("00c9f604-d68f-4438-b90b-7e745772ff87","Sogore","Ibrahim","sogorei@gmail.com","user","12345678",null,null,null,null,null));
				quizService.creerQuiz(quiz2);



			}catch (Exception e){
				e.printStackTrace();
			}

		};

	}

}
