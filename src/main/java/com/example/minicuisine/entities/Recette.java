package com.example.minicuisine.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nom;
    @NotBlank
    @ElementCollection
    private List<String> ingredients;
    @NotBlank
    @ElementCollection
    private List<String> etapes;
    @NotBlank
    private int dureePreparation;

    private String photo; // Chemin vers la photo

    @ManyToOne
    private Utilisateur utilisateur;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)



}
