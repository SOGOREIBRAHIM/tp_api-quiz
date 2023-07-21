package com.api_quiz.api.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Reponse {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReponse;

    @NotNull(message = "Remplissez les champs vides")
    @Size(max = 100, message = "Texte trop long")
    private String text;

    @NotNull(message = "Remplissez les champs vides")
    private boolean status;

    @NotNull(message = "Remplissez les champs vides")
    @Temporal(TemporalType.TIME)    // retourner l'heure
    private Date tempsReponse;

    @ManyToOne
    private User usersReponse;

    @OneToOne
    private Resultat resultatReponse;

    @ManyToOne
    private Question questionReponse;


}
