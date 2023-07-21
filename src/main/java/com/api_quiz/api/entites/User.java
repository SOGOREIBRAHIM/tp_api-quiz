package com.api_quiz.api.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "USERS")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "nom")
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String nom;

    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String prenom;

    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    @Email(message = "Entrez un email valide !")
    private String email;

    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 20, message = "Texte trop long")
    private String username;

    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 10, message = "Mot de passe trop long")
    private String password;

    @ManyToMany(mappedBy = "quizUsers")
    private List<Quiz> usersQuiz ;

    @OneToMany(mappedBy = "creerUser",fetch = FetchType.LAZY)
    private List<Quiz> creerQuiz;

    @OneToMany(mappedBy = "userQuestion", fetch = FetchType.LAZY)
    private List<Question> questionsUser;

    @OneToMany(mappedBy = "usersReponse", fetch = FetchType.LAZY)
    private List<Reponse> reponseUser;

    @OneToMany(mappedBy = "usersResultat", fetch = FetchType.LAZY)
    private List<Resultat> resultatUser;


}
