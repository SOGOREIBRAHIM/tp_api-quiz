package com.api_quiz.api.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Resultat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResultat;

    @NotNull(message = "Remplissez le champs vide")
    @Max(value = 500, message = "Vous ne pouvez pas depasser 50 questions")
    private int score;

    @NotNull(message = "Remplissez le champs vide")
    @Max(value = 50, message = "Vous ne pouvez pas depasser 50 joueurs")
    private int rang;

    @OneToOne
    private User usersResultat;

    @ManyToOne
    private Quiz quizResultat;

    @ManyToOne
    private Reponse reponsesResultat;



}
