package com.example.minicuisine.services;

import com.example.minicuisine.entities.Recette;
import com.example.minicuisine.entities.Utilisateur;
import com.example.minicuisine.exceptions.RecetteNotFoundException;
import com.example.minicuisine.exceptions.UtilisateurNotFoundException;

import java.util.List;

public interface RecetteService {
    //Methdode pour creer des recettes
    public void creerRecette(Recette recette, Utilisateur utilisateur) throws UtilisateurNotFoundException;

    //Methdode pour lire des recettes
    public List<Recette> recupererRecettesUtilisateur(Utilisateur utilisateur) throws UtilisateurNotFoundException;

    //Methdode pour lire une recette
    public Recette recupererRecetteParId(Long recetteId)throws RecetteNotFoundException;

    //Methdode pour update une recette
    public void mettreAJourRecette(Recette recette)throws RecetteNotFoundException;

    //Methdode pour supp une recette
    public void supprimerRecette(Long recetteId, Utilisateur utilisateur) throws UtilisateurNotFoundException, RecetteNotFoundException;

}
