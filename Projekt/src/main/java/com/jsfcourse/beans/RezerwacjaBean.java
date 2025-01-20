package com.jsfcourse.beans;

import com.jsfcourse.dao.RezerwacjaDAO;
import com.jsfcourse.entities.Rezerwacja;
import com.jsfcourse.entities.Uzytkownik;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Collections;
import java.util.List;

@Named
@RequestScoped
public class RezerwacjaBean {

    @Inject
    private RezerwacjaDAO rezerwacjaDAO;

    @Inject
    private UzytkownikBean uzytkownikBean;

    public List<Rezerwacja> getWszystkieRezerwacje() {
        return rezerwacjaDAO.findAll();
    }

    public List<Rezerwacja> getRezerwacjeUzytkownika() {
        if (uzytkownikBean.getZalogowanyUzytkownik() != null) {
            return rezerwacjaDAO.findByUserId(uzytkownikBean.getZalogowanyUzytkownik().getId());
        }
        return Collections.emptyList();
    }

    public void aktualizujStatus(Rezerwacja rezerwacja) {
        try {
            rezerwacjaDAO.update(rezerwacja);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void zmienRole(Uzytkownik uzytkownik, String nowaRola) {
        try {
            uzytkownik.setRola(nowaRola);
            rezerwacjaDAO.updateUzytkownik(uzytkownik);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
