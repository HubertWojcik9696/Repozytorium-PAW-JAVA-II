package com.jsfcourse.dao;

import com.jsfcourse.entities.Samochod;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

public class SamochodDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(Samochod Samochod) {
        em.persist(Samochod);
    }

    public Samochod findById(Integer id) {
        return em.find(Samochod.class, id);
    }

    @Transactional
    public void update(Samochod Samochod) {
        em.merge(Samochod);
    }

    @Transactional
    public void delete(Integer id) {
        Samochod Samochod = findById(id);
        if (Samochod != null) {
            em.remove(Samochod);
        }
    }

    public List<Samochod> findAll() {
        return em.createNamedQuery("Samochod.findAll", Samochod.class).getResultList();
    }
}