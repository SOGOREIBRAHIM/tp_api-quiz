package com.api_quiz.api.services;

import com.api_quiz.api.entites.Resultat;
import com.api_quiz.api.repository.IResultatRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
@AllArgsConstructor
public class ResultatServiceImpl implements IResultatService{

    private IResultatRepository resultatRepository;
    private IQuizService quizService;


//    methode obtenir un resultat
    @Override
    public Resultat obtenir(Resultat resultat) {
        return resultatRepository.save(resultat);
    }

//    methode afficher liste tous les resultat
    @Override
    public List<Resultat> listAllResultat() {
        return resultatRepository.findAll();
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public Resultat lisResultat(Long id) {
        return resultatRepository.findById(id).get();
    }

    /**
     * @param
     * @return
     */
    @Override
    public void supprimer(Long idResultat) {
        resultatRepository.deleteById(idResultat);
    }
}
