package com.api_quiz.api;

import com.api_quiz.api.entites.NiveauEnum;
import com.api_quiz.api.entites.Question;
import com.api_quiz.api.services.IQuestionService;
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
	@Bean
	CommandLineRunner start(IQuestionService iQuestionService){
		return args -> {
			Stream.of("Titre1", "Titre2", "Titre3")
					.forEach(name->{
						Question question = new Question();
						question.setTitre(name);
						question.setText("Quel est la capitale du Mali");
						question.setNiveau(NiveauEnum.FACILE);
						question.setTempsQuestion(new Date());
						iQuestionService.creerQuestion(question);
					});
		};
	}

}
