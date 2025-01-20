/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jsfcourse.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author huber
 */
@Entity
@Table(name = "rezerwacje")
@NamedQueries({
    @NamedQuery(name = "Rezerwacja.findAll", query = "SELECT r FROM Rezerwacja r"),
    @NamedQuery(name = "Rezerwacja.findById", query = "SELECT r FROM Rezerwacja r WHERE r.id = :id"),
    @NamedQuery(name = "Rezerwacja.findByDataRozpoczecia", query = "SELECT r FROM Rezerwacja r WHERE r.dataRozpoczecia = :dataRozpoczecia"),
    @NamedQuery(name = "Rezerwacja.findByDataZakonczenia", query = "SELECT r FROM Rezerwacja r WHERE r.dataZakonczenia = :dataZakonczenia"),
    @NamedQuery(name = "Rezerwacja.findByStatus", query = "SELECT r FROM Rezerwacja r WHERE r.status = :status"),
    @NamedQuery(name = "Rezerwacja.findByDataUtworzenia", query = "SELECT r FROM Rezerwacja r WHERE r.dataUtworzenia = :dataUtworzenia")})
public class Rezerwacja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_rozpoczecia")
    @Temporal(TemporalType.DATE)
    private Date dataRozpoczecia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_zakonczenia")
    @Temporal(TemporalType.DATE)
    private Date dataZakonczenia;
    @Size(max = 12)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_utworzenia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUtworzenia;
    @JoinColumn(name = "id_samochodu", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Samochod idSamochodu;
    @JoinColumn(name = "id_uzytkownika", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Uzytkownik idUzytkownika;

    public Rezerwacja() {
    }

    public Rezerwacja(Integer id) {
        this.id = id;
    }

    public Rezerwacja(Integer id, Date dataRozpoczecia, Date dataZakonczenia, Date dataUtworzenia) {
        this.id = id;
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia = dataZakonczenia;
        this.dataUtworzenia = dataUtworzenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(Date dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public Samochod getIdSamochodu() {
        return idSamochodu;
    }

    public void setIdSamochodu(Samochod idSamochodu) {
        this.idSamochodu = idSamochodu;
    }

    public Uzytkownik getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Uzytkownik idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
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
        if (!(object instanceof Rezerwacja)) {
            return false;
        }
        Rezerwacja other = (Rezerwacja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.Rezerwacja[ id=" + id + " ]";
    }
    
}
