package com.example.minicuisine.mappers;

import com.example.minicuisine.dtos.RecetteDTO;
import com.example.minicuisine.entities.Recette;
import com.example.minicuisine.services.RecetteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RecetteMapperImpl {
/*

    private final RecetteService recetteService;

    @Autowired
    public RecetteController(RecetteService recetteService) {
        this.recetteService = recetteService;
    }

    @GetMapping("Recette/{id}")
    public RecetteDTO getRecetteById(@PathVariable Long id) {
        return recetteService.recupererRecetteParId(id);
    }

    @PostMapping
    public RecetteDTO createRecette(@RequestBody RecetteDTO recetteDTO) {
        return recetteService.mettreAJourRecette(recetteDTO);
    }*/
    public RecetteDTO fromRecette (Recette recette){
        RecetteDTO recetteDTO=new RecetteDTO();
        BeanUtils.copyProperties(recette,recetteDTO);


        return recetteDTO;
    }
    public Recette fromRecette (RecetteDTO recetteDTO){
        Recette recette=new Recette();
        BeanUtils.copyProperties(recetteDTO,recette);
        return recette;
    }
    //public SavingRecette fromRecette (mettreAJourRecette)
}
