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
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author huber
 */
@Entity
@Table(name = "samochody")
@NamedQueries({
    @NamedQuery(name = "Samochod.findAll", query = "SELECT s FROM Samochod s"),
    @NamedQuery(name = "Samochod.findById", query = "SELECT s FROM Samochod s WHERE s.id = :id"),
    @NamedQuery(name = "Samochod.findByMarka", query = "SELECT s FROM Samochod s WHERE s.marka = :marka"),
    @NamedQuery(name = "Samochod.findByModel", query = "SELECT s FROM Samochod s WHERE s.model = :model"),
    @NamedQuery(name = "Samochod.findByRok", query = "SELECT s FROM Samochod s WHERE s.rok = :rok"),
    @NamedQuery(name = "Samochod.findByCenaNaDzien", query = "SELECT s FROM Samochod s WHERE s.cenaNaDzien = :cenaNaDzien"),
    @NamedQuery(name = "Samochod.findByDataUtworzenia", query = "SELECT s FROM Samochod s WHERE s.dataUtworzenia = :dataUtworzenia")})
public class Samochod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marka")
    private String marka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rok")
    private int rok;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena_na_dzien")
    private BigDecimal cenaNaDzien;
    @Lob
    @Size(max = 65535)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_utworzenia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUtworzenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSamochodu")
    private Collection<Rezerwacja> rezerwacjaCollection;

    public Samochod() {
    }

    public Samochod(Integer id) {
        this.id = id;
    }

    public Samochod(Integer id, String marka, String model, int rok, BigDecimal cenaNaDzien, Date dataUtworzenia) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.rok = rok;
        this.cenaNaDzien = cenaNaDzien;
        this.dataUtworzenia = dataUtworzenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public BigDecimal getCenaNaDzien() {
        return cenaNaDzien;
    }

    public void setCenaNaDzien(BigDecimal cenaNaDzien) {
        this.cenaNaDzien = cenaNaDzien;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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
        if (!(object instanceof Samochod)) {
            return false;
        }
        Samochod other = (Samochod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfcourse.entities.Samochod[ id=" + id + " ]";
    }
    
}
