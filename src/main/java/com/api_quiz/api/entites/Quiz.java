package com.api_quiz.api.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor    // lombok
@Table(name = "Quiz")
public class Quiz {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuiz;

    @Column(name = "nom")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 100, message = "Texte trop long")
    private String nom;

    @Column(name = "type")
    @NotNull(message = "Remplissez les champs vides")
    private TypeEnum type;

    @Column(name = "dureeTotal")
    @NotNull(message = "Remplissez les champs vides")
    private int dureeTotal;

    @Column(name = "domaine")
    @NotNull(message = "Remplissez les champs vides")
    private DomaineEnum domaine;

    @ManyToMany    // pour charger objet automatiquemnet
    private List<User> quizUsers = new ArrayList<>();   //pour associer un jeux a un user

    @OneToMany(mappedBy = "quizResultat",fetch = FetchType.LAZY)
    private List<Resultat> resultatQuiz;

    @OneToMany(mappedBy = "quizQuestion", fetch = FetchType.LAZY)
    private List<Question> questionsQuiz;

}
