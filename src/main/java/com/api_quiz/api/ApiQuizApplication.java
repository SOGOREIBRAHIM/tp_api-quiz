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
	//@Bean
	CommandLineRunner start(IUserService userService, IQuizService quizService){
		return args -> {
			try {
				User user = new User();
				user.setIdUser(null);
				user.setNom("Guindo");
				user.setPrenom("Ibrahima");
				user.setEmail("ib@gmail.com");
				user.setUsername("ib223");
				user.setPassword("12345678");
				userService.inscrire(user);

				User user2 = new User();
				user2.setIdUser(null);
				user2.setNom("Togo");
				user2.setPrenom("Drissa");
				user2.setEmail("dt@gmail.com");
				user2.setUsername("d_togo");
				user2.setPassword("12345678a");
				userService.inscrire(user2);
				/*User user1 = userService.connecter("user","12345678");
				System.out.println(user1.getIdUser());
				System.out.println(user1.getUsername());*/

				/*Quiz quiz = new Quiz();
				quiz.setIdQuiz(null);
				quiz.setNom("Question Java");
				quiz.setType(EnumType.NOUVEAU);
				quiz.setDureeTotal(new Date());
				quiz.setDomaine(EnumDomaine.JAVASCRIPT);
				quiz.setCreerUser(new User("7893c1ee-c4f1-4ebb-a210-8624833a6692","Guindo","Ibrahima","ib@gmail.com","ib223","12345678",null,null,null,null,null));
				quizService.creerQuiz(quiz);

				Quiz quiz2 = new Quiz();
				quiz2.setIdQuiz(null);
				quiz2.setNom("Question Python");
				quiz2.setType(EnumType.NOUVEAU);
				quiz2.setDureeTotal(new Date());
				quiz2.setDomaine(EnumDomaine.JAVA);
				quiz2.setCreerUser(new User("c59e677b-648a-42df-94de-cab78887d7aa","Togo","Drissa","dt@gmail.com","d_togo","12345678",null,null,null,null,null));
				quizService.creerQuiz(quiz2);*/


			}catch (Exception e){
				e.printStackTrace();
			}

		};

	}

}
