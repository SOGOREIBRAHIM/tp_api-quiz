package com.api_quiz.api.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor    // lombok
public class Jeux {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)     // cle primaire et auto incrementaton
    private Long idJeux;

    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 100, message = "Texte trop long")
    private String nom;

    @NotNull(message = "Remplissez les champs vides")
    private TypeEnum type;

    @NotNull(message = "Remplissez les champs vides")
    private int dureeTotal;

    @NotNull(message = "Remplissez les champs vides")
    private DomaineEnum domaine;

    @OneToMany(mappedBy = "jeuxUser", fetch = FetchType.LAZY)
    private Collection<User> usersJeux;

    @OneToOne
    private Resultat resultatJeux;

    @OneToMany(mappedBy = "jeuxQuestion", fetch = FetchType.LAZY)
    private Collection<Question> questionsJeux;

}
