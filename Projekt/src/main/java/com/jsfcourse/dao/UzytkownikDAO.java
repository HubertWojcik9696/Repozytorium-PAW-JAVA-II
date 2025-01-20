package com.jsfcourse.dao;

import com.jsfcourse.entities.Uzytkownik;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UzytkownikDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(Uzytkownik Uzytkownik) {
        em.persist(Uzytkownik);
    }

    public Uzytkownik findById(Integer id) {
        return em.find(Uzytkownik.class, id);
    }

    @Transactional
    public void update(Uzytkownik Uzytkownik) {
        em.merge(Uzytkownik);
    }

    @Transactional
    public void delete(Integer id) {
        Uzytkownik Uzytkownik = findById(id);
        if (Uzytkownik != null) {
            em.remove(Uzytkownik);
        }
    }

    public List<Uzytkownik> findAll() {
        return em.createNamedQuery("Uzytkownik.findAll", Uzytkownik.class).getResultList();
    }
    
    public Uzytkownik findByNazwaUzytkownika(String nazwaUzytkownika) {
    try {
        return em.createNamedQuery("Uzytkownik.findByNazwaUzytkownika", Uzytkownik.class)
                 .setParameter("nazwaUzytkownika", nazwaUzytkownika)
                 .getSingleResult();
    } catch (Exception e) {
        return null;
    }
}
}