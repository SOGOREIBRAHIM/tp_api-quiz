package com.api_quiz.api.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Remplissez les champs vides")
    private NiveauEnum niveau;

    @Temporal(TemporalType.TIME)
    private Date tempsQuestion;

    @ManyToOne
    private User userQuestion;

    @OneToMany(mappedBy = "questionReponse", fetch = FetchType.LAZY)
    private List<Reponse> reponseReponse;

    @ManyToOne
    private Quiz quizQuestion;
}

