package com.example.minicuisine.repositories;

import com.example.minicuisine.entities.Recette;
import com.example.minicuisine.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteRepository extends JpaRepository <Recette, Long>{
}
