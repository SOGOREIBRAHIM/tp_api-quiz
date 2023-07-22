package com.api_quiz.api.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor    // lombok
@Table(name = "QUIZ")
public class Quiz {

    @Id
    private String idQuiz;

    @Column(name = "NOM", length = 50, unique = true)
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 100, message = "Texte trop long")
    private String nom;

    @Column(name = "TYPE")
    @NotNull(message = "Remplissez les champs vides")
    private TypeEnum type;

    @Temporal(TemporalType.TIME)
    @Column(name = "DUREE_TOTAL")
    @NotNull(message = "Remplissez les champs vides")
    private Date dureeTotal;

    @Column(name = "DOMAINE")
    @NotNull(message = "Remplissez les champs vides")
    private DomaineEnum domaine;

    @ManyToMany(fetch = FetchType.EAGER)    // pour charger objet automatiquemnet
    private List<User> quizUsers = new ArrayList<>();   //pour associer un jeux a un user

    @ManyToOne
    private User creerUser;

    @OneToMany(mappedBy = "quizResultat",fetch = FetchType.LAZY)
    private List<Resultat> resultatQuiz;


    @OneToMany(mappedBy = "quizQuestion", fetch = FetchType.LAZY)
    private List<Question> questionsQuiz;

}
