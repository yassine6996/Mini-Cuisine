package com.example.minicuisine.services;

import com.example.minicuisine.entities.Recette;
import com.example.minicuisine.entities.Utilisateur;
import com.example.minicuisine.exceptions.RecetteNotFoundException;
import com.example.minicuisine.exceptions.UtilisateurNotFoundException;
import com.example.minicuisine.repositories.RecetteRepository;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
@AllArgsConstructor
@Stateless
@Slf4j
public class RecetteServiceImpl implements RecetteService{
    @PersistenceContext
    private EntityManager entityManager;
    //Logger log= LoggerFactory.getLogger(this.getClass().getName());
    @Override
    public void creerRecette(Recette recette, Utilisateur utilisateur) throws UtilisateurNotFoundException {
        if(utilisateur==null)
            throw new UtilisateurNotFoundException("Utilisateur n'existe pas");
        log.info("Creer Recette");
        recette.setUtilisateur(utilisateur);
        entityManager.persist(recette);
    }
    @Override
    public List<Recette> recupererRecettesUtilisateur(Utilisateur utilisateur) throws UtilisateurNotFoundException{
        if(utilisateur==null)
            throw new UtilisateurNotFoundException("Utilisateur n'existe pas");
        TypedQuery<Recette> query = entityManager.createQuery(
                "SELECT r FROM Recette r WHERE r.utilisateur = :utilisateur",
                Recette.class
        );
        query.setParameter("utilisateur", utilisateur);
        return query.getResultList();
    }
    @Override
    public Recette recupererRecetteParId(Long recetteId) throws  RecetteNotFoundException {
        /*Recette rec = RecetteRepository.findById(recetteId)
                .orElseThrow(()->new RecetteNotFoundException("Recette Not found"));*/

        if(recetteId==null)
            throw new RecetteNotFoundException("Recette n'existe pas");
        return entityManager.find(Recette.class, recetteId);
    }
    @Override
    public void mettreAJourRecette(Recette recette) throws  RecetteNotFoundException {
        if(recette==null)
            throw new RecetteNotFoundException("Recette n'existe pas");
        entityManager.merge(recette);
    }
    @Override
    public void supprimerRecette(Long recetteId, Utilisateur utilisateur) throws UtilisateurNotFoundException, RecetteNotFoundException {
        if(utilisateur==null)
            throw new UtilisateurNotFoundException("Utilisateur n'existe pas");
        if(recetteId==null)
            throw new RecetteNotFoundException("Recette n'existe pas");
        Recette recette = entityManager.find(Recette.class, recetteId);
        if (recette != null && recette.getUtilisateur().equals(utilisateur)) {
            entityManager.remove(recette);
        }
    }
}
