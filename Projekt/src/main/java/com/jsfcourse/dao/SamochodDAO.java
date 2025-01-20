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
    public void create(Samochod samochod) {
        em.persist(samochod);
    }

    public Samochod findById(Integer id) {
        return em.find(Samochod.class, id);
    }

    @Transactional
    public void update(Samochod samochod) {
        em.merge(samochod);
    }

    @Transactional
    public void delete(Integer id) {
        Samochod samochod = findById(id);
        if (samochod != null) {
            em.remove(samochod);
        }
    }

    @Transactional
    public void delete(Samochod samochod) {
        if (samochod != null && !em.contains(samochod)) {
            samochod = em.merge(samochod);
        }
        em.remove(samochod);
    }

    public List<Samochod> findAll() {
        return em.createNamedQuery("Samochod.findAll", Samochod.class).getResultList();
    }

    public List<Samochod> findByMarka(String marka) {
        return em.createQuery("SELECT s FROM Samochod s WHERE s.marka = :marka", Samochod.class)
                 .setParameter("marka", marka)
                 .getResultList();
    }

    public List<Samochod> findByPriceRange(Double minPrice, Double maxPrice) {
        return em.createQuery("SELECT s FROM Samochod s WHERE s.cenaNaDzien BETWEEN :minPrice AND :maxPrice", Samochod.class)
                 .setParameter("minPrice", minPrice)
                 .setParameter("maxPrice", maxPrice)
                 .getResultList();
    }
}
