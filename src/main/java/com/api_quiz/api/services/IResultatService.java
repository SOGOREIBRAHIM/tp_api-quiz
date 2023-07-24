package com.api_quiz.api.services;

import com.api_quiz.api.entites.Resultat;

import java.util.List;

public interface IResultatService {

//    obtenir de resultat a la fin du Quiz
    Resultat obtenir(Resultat resultat);

    List<Resultat> listAllResultat();

    Resultat lisResultat(Long id);

    void supprimer(Long idResultat);
}
