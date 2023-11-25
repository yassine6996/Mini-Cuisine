package com.example.minicuisine.web;

import com.example.minicuisine.dtos.RecetteDTO;
import com.example.minicuisine.entities.Recette;
import com.example.minicuisine.entities.Utilisateur;
import com.example.minicuisine.services.RecetteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecetteRestController {
    private RecetteService recetteService;
@GetMapping("/recettesDTO")
    public List<RecetteDTO> recettes(){
        //return RecetteService.recupererRecettesUtilisateur();
        return null;
    }
    @GetMapping("/recette/{id}")
    public RecetteDTO getRecette(@PathVariable(name="id")Long recetteId){
        //return RecetteService.recupererRecetteById();
        return null;
    }
}
