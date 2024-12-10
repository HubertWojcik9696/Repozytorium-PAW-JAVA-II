package com.jsfcourse.beans;


import com.jsfcourse.entities.Uzytkownik;
import com.wypozyczalnia.service.UzytkownikService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class RejestracjaBean implements Serializable{

    private String login;
    private String haslo;
    private String imie;
    private String nazwisko;

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

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @EJB
    private UzytkownikService uzytkownikService;

    public String zarejestruj() {
        Uzytkownik nowyUzytkownik = new Uzytkownik();
        nowyUzytkownik.setLogin(login);
        nowyUzytkownik.setHaslo(haslo);
        nowyUzytkownik.setImie(imie);
        nowyUzytkownik.setNazwisko(nazwisko);
        nowyUzytkownik.setRola("USER");

        uzytkownikService.zarejestruj(nowyUzytkownik);
        return "logowanie?faces-redirect=true";
    }

}
