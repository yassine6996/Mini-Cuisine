package com.example.minicuisine;

import com.example.minicuisine.entities.Recette;
import com.example.minicuisine.entities.Utilisateur;
import com.example.minicuisine.repositories.RecetteRepository;
import com.example.minicuisine.repositories.UtilisateurRepository;
import com.example.minicuisine.services.RecetteService;
import com.example.minicuisine.services.UtilisateurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.stream.Stream;

@SpringBootApplication
public class MiniCuisineApplication {

    public static void main(String[] args) {SpringApplication.run(MiniCuisineApplication.class, args);}


        CommandLineRunner start(RecetteRepository recetteRepository,
                                UtilisateurRepository utilisateurRepository){
        return args -> {
            Stream.of("yassine", "hicham").forEach(name -> {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setName(name);
                utilisateur.setEmail(name + "@gmail.com");
                utilisateurRepository.save(utilisateur);
            });
        };

        }
    CommandLineRunner commandLineRunner(RecetteRepository recetteRepository)
    {
        return args -> {
            Stream.of("Les pattes", "pizza").forEach(name -> {
                Recette recette = new Recette();
                recette.setNom(name);
                recette.setIngredients(Collections.singletonList("test"));
                recette.setEtapes(Collections.singletonList("test"));
                recette.setDureePreparation(12);
                recette.setUtilisateur(new Utilisateur());

            });
        };
    }

}
