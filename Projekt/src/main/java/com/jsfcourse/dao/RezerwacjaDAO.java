package com.jsfcourse.dao;

import com.jsfcourse.entities.Rezerwacja;
import com.jsfcourse.entities.Uzytkownik;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

public class RezerwacjaDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(Rezerwacja rezerwacja) {
        em.persist(rezerwacja);
    }

    public Rezerwacja findById(Integer id) {
        return em.find(Rezerwacja.class, id);
    }

    @Transactional
    public void update(Rezerwacja rezerwacja) {
        em.merge(rezerwacja);
    }

    @Transactional
    public void updateUzytkownik(Uzytkownik uzytkownik) {
        em.merge(uzytkownik);
    }

    @Transactional
    public void delete(Integer id) {
        Rezerwacja rezerwacja = findById(id);
        if (rezerwacja != null) {
            em.remove(rezerwacja);
        }
    }

    public List<Rezerwacja> findAll() {
        return em.createNamedQuery("Rezerwacja.findAll", Rezerwacja.class).getResultList();
    }
    public List<Rezerwacja> findByUserId(Integer userId) {
    return em.createQuery("SELECT r FROM Rezerwacja r WHERE r.idUzytkownika.id = :userId", Rezerwacja.class)
             .setParameter("userId", userId)
             .getResultList();
}
}
