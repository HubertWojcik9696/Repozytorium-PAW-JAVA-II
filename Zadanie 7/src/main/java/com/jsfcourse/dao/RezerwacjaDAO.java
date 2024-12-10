package com.jsfcourse.dao;

import com.jsfcourse.entities.Rezerwacja;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

public class RezerwacjaDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(Rezerwacja Rezerwacja) {
        em.persist(Rezerwacja);
    }

    public Rezerwacja findById(Integer id) {
        return em.find(Rezerwacja.class, id);
    }

    @Transactional
    public void update(Rezerwacja Rezerwacja) {
        em.merge(Rezerwacja);
    }

    @Transactional
    public void delete(Integer id) {
        Rezerwacja Rezerwacja = findById(id);
        if (Rezerwacja != null) {
            em.remove(Rezerwacja);
        }
    }

    public List<Rezerwacja> findAll() {
        return em.createNamedQuery("Rezerwacja.findAll", Rezerwacja.class).getResultList();
    }
}