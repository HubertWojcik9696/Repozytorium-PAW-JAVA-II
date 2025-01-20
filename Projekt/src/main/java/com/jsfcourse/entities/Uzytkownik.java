/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jsfcourse.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author huber
 */
@Entity
@Table(name = "uzytkownicy")
@NamedQueries({
    @NamedQuery(name = "Uzytkownik.findAll", query = "SELECT u FROM Uzytkownik u"),
    @NamedQuery(name = "Uzytkownik.findById", query = "SELECT u FROM Uzytkownik u WHERE u.id = :id"),
    @NamedQuery(name = "Uzytkownik.findByImie", query = "SELECT u FROM Uzytkownik u WHERE u.imie = :imie"),
    @NamedQuery(name = "Uzytkownik.findByNazwisko", query = "SELECT u FROM Uzytkownik u WHERE u.nazwisko = :nazwisko"),
    @NamedQuery(name = "Uzytkownik.findByNazwaUzytkownika", query = "SELECT u FROM Uzytkownik u WHERE u.nazwaUzytkownika = :nazwaUzytkownika"),
    @NamedQuery(name = "Uzytkownik.findByHaslo", query = "SELECT u FROM Uzytkownik u WHERE u.haslo = :haslo"),
    @NamedQuery(name = "Uzytkownik.findByEmail", query = "SELECT u FROM Uzytkownik u WHERE u.email = :email"),
    @NamedQuery(name = "Uzytkownik.findByRola", query = "SELECT u FROM Uzytkownik u WHERE u.rola = :rola"),
    @NamedQuery(name = "Uzytkownik.findByDataUtworzenia", query = "SELECT u FROM Uzytkownik u WHERE u.dataUtworzenia = :dataUtworzenia")})
public class Uzytkownik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwa_uzytkownika")
    private String nazwaUzytkownika;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "haslo")
    private String haslo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "rola")
    private String rola;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_utworzenia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUtworzenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUzytkownika")
    private Collection<Rezerwacja> rezerwacjaCollection;

    public Uzytkownik() {
    }

    public Uzytkownik(Integer id) {
        this.id = id;
    }

    public Uzytkownik(Integer id, String imie, String nazwisko, String nazwaUzytkownika, String haslo, String email, String rola, Date dataUtworzenia) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nazwaUzytkownika = nazwaUzytkownika;
        this.haslo = haslo;
        this.email = email;
        this.rola = rola;
        this.dataUtworzenia = dataUtworzenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNazwaUzytkownika() {
        return nazwaUzytkownika;
    }

    public void setNazwaUzytkownika(String nazwaUzytkownika) {
        this.nazwaUzytkownika = nazwaUzytkownika;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public Collection<Rezerwacja> getRezerwacjaCollection() {
        return rezerwacjaCollection;
    }

    public void setRezerwacjaCollection(Collection<Rezerwacja> rezerwacjaCollection) {
        this.rezerwacjaCollection = rezerwacjaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uzytkownik)) {
            return false;
        }
        Uzytkownik other = (Uzytkownik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.Uzytkownik[ id=" + id + " ]";
    }

    public void setLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
