package com.api_quiz.api.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Quiz> usersQuiz = new ArrayList<>() ;

    @OneToMany(mappedBy = "creerUser",fetch = FetchType.EAGER,orphanRemoval = true)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Quiz> creerQuiz=new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "userQuestion", fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Question> questionsUser=new ArrayList<>();

    @OneToMany(mappedBy = "usersReponse", fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Reponse> reponseUser=new ArrayList<>();


    @OneToMany(mappedBy = "usersResultat", fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Resultat> resultatUser=new ArrayList<>();


}
