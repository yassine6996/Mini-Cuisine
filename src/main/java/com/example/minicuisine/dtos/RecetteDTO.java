package com.example.minicuisine.dtos;

import com.example.minicuisine.entities.Utilisateur;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class RecetteDTO {
    private Long id;
    private String nom;
    @ElementCollection
    private List<String> ingredients;
    @ElementCollection
    private List<String> etapes;
    private int dureePreparation;
    private String photo; // Chemin vers la photo





}
