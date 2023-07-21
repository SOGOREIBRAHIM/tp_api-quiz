package com.api_quiz.api.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor    // lombok
@Table(name = "JEUX")
public class Jeux {

    @Id
    private String idJeux;

    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 100, message = "Texte trop long")
    private String nom;

    @NotNull(message = "Remplissez les champs vides")
    private TypeEnum type;

    @NotNull(message = "Remplissez les champs vides")
    private int dureeTotal;

    @NotNull(message = "Remplissez les champs vides")
    private DomaineEnum domaine;

    @ManyToMany(mappedBy = "jeuxUser", fetch = FetchType.EAGER)     // pour charger objet automatiquemnet
    private List<User> usersJeux = new ArrayList<>();

    @OneToOne
    private Resultat resultatJeux;

    @OneToMany(mappedBy = "jeuxQuestion", fetch = FetchType.LAZY)
    private List<Question> questionsJeux;

}
