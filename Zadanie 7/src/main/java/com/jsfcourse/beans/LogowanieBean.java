package com.jsfcourse.beans;

import com.jsfcourse.entities.Uzytkownik;
import com.wypozyczalnia.service.UzytkownikService;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.ejb.EJB;
import java.io.Serializable;

@Named
@SessionScoped
public class LogowanieBean implements Serializable {
    private String login;
    private String haslo;

    @EJB
    private UzytkownikService uzytkownikService;

    public String zaloguj() {
        Uzytkownik uzytkownik = uzytkownikService.znajdzPoLoginie(login);
        if (uzytkownik != null && uzytkownik.getHaslo().equals(haslo)) {
            return "index?faces-redirect=true";
        }
        return null;
    }

    public String wyloguj() {
        return "index?faces-redirect=true";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
