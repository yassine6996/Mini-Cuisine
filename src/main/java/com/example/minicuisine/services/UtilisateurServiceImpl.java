package com.example.minicuisine.services;

import com.example.minicuisine.entities.Recette;
import com.example.minicuisine.entities.Utilisateur;
import com.example.minicuisine.exceptions.UtilisateurNotFoundException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Stateless
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService{
    @PersistenceContext
    private EntityManager entityManager;
@Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur)  {

    entityManager.persist(utilisateur);
    return utilisateur;
    }
    @Override
    public List<Utilisateur> listUtilisateur() {
        TypedQuery<Utilisateur> query = entityManager.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class);
        return query.getResultList();
    }
    @Override
    public Utilisateur findById(Long id) throws UtilisateurNotFoundException {
        return entityManager.find(Utilisateur.class, id);
    }
}
