package com.example.minicuisine.web;

import com.example.minicuisine.entities.Utilisateur;
import com.example.minicuisine.services.UtilisateurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurRestController {
    private UtilisateurService utilisateurService;
    @GetMapping("/Utilisateur")
    public List<Utilisateur> utilisateurs(){
        //return UtilisateurService.listUtilisateur();
        return null;
    }
}
