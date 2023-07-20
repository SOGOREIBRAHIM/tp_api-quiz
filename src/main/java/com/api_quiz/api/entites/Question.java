package com.api_quiz.api.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuestion;

    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 100, message = "Texte trop long")
    private String titre;

    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 100, message = "Texte trop long")
    private String text;

    @NotNull(message = "Remplissez les champs vides")
    private NiveauEnum niveau;

    @Temporal(TemporalType.TIME)
    private Date tempsQuestion;

    @OneToMany(mappedBy = "questionsUser", fetch = FetchType.LAZY)
    private Collection<User> usersQuestion;

    @OneToOne
    private Reponse reponseReponse;

    @OneToOne
    private Jeux jeuxQuestion;
}

