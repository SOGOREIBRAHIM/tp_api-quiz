package com.api_quiz.api.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    private String idUser;

    @Column(name = "NOM", length = 50)
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String nom;

    @Column(name = "PRENOM", length = 50)
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 50, message = "Texte trop long")
    private String prenom;

    @Column(name = "EMAIL", length = 80, unique = true)
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 80, message = "Texte trop long")
    @Email(message = "Entrez un email valide !")
    private String email;

    @Column(name = "USERNAME", length = 50, unique = true)
    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 20, message = "Texte trop long")
    private String username;

    @NotNull(message = "Remplissez les champs vides")
    @Size(min = 8, message = "Mot de passe trop faible")
    private String password;

    @ManyToMany(mappedBy = "quizUsers",fetch = FetchType.EAGER)
//    @JoinTable(name = "USER_QUIZ")         // pas obligatoire mais recommander
    private List<Quiz> usersQuiz = new ArrayList<>() ;


    @OneToMany(mappedBy = "creerUser",fetch = FetchType.LAZY,orphanRemoval = true)
//    @Cascade({ org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    private List<Quiz> creerQuiz;

    @OneToMany(mappedBy = "userQuestion", fetch = FetchType.LAZY,orphanRemoval = true)
//    @Cascade({ org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    private List<Question> questionsUser;

    @OneToMany(mappedBy = "usersReponse", fetch = FetchType.LAZY,orphanRemoval = true)
//    @Cascade({ org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    private List<Reponse> reponseUser;

    @OneToMany(mappedBy = "usersResultat", fetch = FetchType.LAZY,orphanRemoval = true)
//    @Cascade({ org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
    private List<Resultat> resultatUser;


}
