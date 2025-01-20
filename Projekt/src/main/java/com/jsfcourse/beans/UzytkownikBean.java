package com.jsfcourse.beans;

import com.jsfcourse.dao.UzytkownikDAO;
import com.jsfcourse.entities.Uzytkownik;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class UzytkownikBean implements Serializable {

    private String imie;
    private String nazwisko;
    private String nazwaUzytkownika;
    private String email;
    private String haslo;
    private Uzytkownik zalogowanyUzytkownik;

    @Inject
    private UzytkownikDAO uzytkownikDAO;

    public String rejestruj() {
        try {
            Uzytkownik nowyUzytkownik = new Uzytkownik();
            nowyUzytkownik.setImie(imie);
            nowyUzytkownik.setNazwisko(nazwisko);
            nowyUzytkownik.setNazwaUzytkownika(nazwaUzytkownika);
            nowyUzytkownik.setEmail(email);
            nowyUzytkownik.setHaslo(haslo);
            nowyUzytkownik.setRola("uzytkownik");
            nowyUzytkownik.setDataUtworzenia(new Date());

            uzytkownikDAO.create(nowyUzytkownik);
            return "login.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String loguj() {
        Uzytkownik uzytkownik = uzytkownikDAO.findByNazwaUzytkownika(nazwaUzytkownika);

        if (uzytkownik != null && uzytkownik.getHaslo().equals(haslo)) {
            zalogowanyUzytkownik = uzytkownik;

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uzytkownikBean", this);

            return "index.xhtml?faces-redirect=true";
        } else {
            return null;
        }
    }

    public String wyloguj() {
        zalogowanyUzytkownik = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }

    public boolean isZalogowany() {
        return zalogowanyUzytkownik != null;
    }

    public List<Uzytkownik> getWszyscyUzytkownicy() {
        return uzytkownikDAO.findAll();
    }

    public void aktualizujRole(Uzytkownik uzytkownik) {
        try {
            uzytkownikDAO.update(uzytkownik);
            FacesContext.getCurrentInstance().addMessage(null, 
                new jakarta.faces.application.FacesMessage("Rola użytkownika została zaktualizowana."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new jakarta.faces.application.FacesMessage(jakarta.faces.application.FacesMessage.SEVERITY_ERROR, 
                "Nie udało się zaktualizować roli użytkownika.", null));
            e.printStackTrace();
        }
    }

    public String getImie() { return imie; }
    public void setImie(String imie) { this.imie = imie; }
    public String getNazwisko() { return nazwisko; }
    public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }
    public String getNazwaUzytkownika() { return nazwaUzytkownika; }
    public void setNazwaUzytkownika(String nazwaUzytkownika) { this.nazwaUzytkownika = nazwaUzytkownika; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getHaslo() { return haslo; }
    public void setHaslo(String haslo) { this.haslo = haslo; }
    public Uzytkownik getZalogowanyUzytkownik() { return zalogowanyUzytkownik; }
    public void setZalogowanyUzytkownik(Uzytkownik zalogowanyUzytkownik) { this.zalogowanyUzytkownik = zalogowanyUzytkownik; }
}
