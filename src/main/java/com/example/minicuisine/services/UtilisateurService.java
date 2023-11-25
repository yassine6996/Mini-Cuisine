package com.example.minicuisine.services;

import com.example.minicuisine.entities.Utilisateur;
import com.example.minicuisine.exceptions.UtilisateurNotFoundException;

import java.util.List;

public interface UtilisateurService {
     Utilisateur saveUtilisateur (Utilisateur utilisateur);
     List<Utilisateur> listUtilisateur();
     public Utilisateur findById(Long id) throws UtilisateurNotFoundException;

}
