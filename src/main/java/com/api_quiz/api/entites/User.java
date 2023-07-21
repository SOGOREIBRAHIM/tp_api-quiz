package com.api_quiz.api.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    private String idUser;

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

    @ManyToMany
    private List<Jeux> jeuxUser;

    @OneToOne
    private Question questionsUser;

    @OneToOne
    private Reponse reponse;

    @OneToOne
    private Resultat resultat;


}
