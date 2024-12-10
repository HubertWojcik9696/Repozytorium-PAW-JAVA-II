package com.wypozyczalnia.service;


import com.jsfcourse.entities.Uzytkownik;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UzytkownikService {

    @PersistenceContext
    private EntityManager em;

    public Uzytkownik znajdzPoLoginie(String login) {
        try {
            return em.createQuery("SELECT u FROM Uzytkownik u WHERE u.login = :login", Uzytkownik.class)
                     .setParameter("login", login)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void zarejestruj(Uzytkownik uzytkownik) {
        em.persist(uzytkownik);
    }
}
