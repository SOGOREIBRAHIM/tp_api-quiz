package com.api_quiz.api.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    private EnumNiveau niveau;

    @Temporal(TemporalType.TIME)
    private Date tempsQuestion;

    @ManyToOne
    private User userQuestion;

    @OneToMany(mappedBy = "questionReponse", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Reponse> reponseReponse=new ArrayList<>();

    @ManyToOne
    private Quiz quizQuestion;
}

