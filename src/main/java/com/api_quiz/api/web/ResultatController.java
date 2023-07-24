package com.api_quiz.api.web;

import com.api_quiz.api.entites.Resultat;
import com.api_quiz.api.services.IResultatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ResultatController {
    private IResultatService resultatService;   // injection de l'interface

//    methode obtenir resultat
    @PostMapping("/obtenir")
    private Resultat obtenir(@RequestBody Resultat resultat){
        return resultatService.obtenir(resultat);
    }

//    afficher tous les resultat
    @GetMapping("/listAll")
    private List<Resultat> resultatListAll(){
        return resultatService.listAllResultat();
    }

    @GetMapping("/listParId")
    private Resultat resultatList(@RequestParam Long id){
        return resultatService.lisResultat(id);
    }

    @GetMapping("/supprimerResultat")
    private String supprimer(@RequestParam Long id){
        resultatService.supprimer(id);
        return "Supprimer avec succes";
    }
}
