package com.jsfcourse.beans;

import com.jsfcourse.dao.SamochodDAO;
import com.jsfcourse.entities.Samochod;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class SamochodBean implements Serializable {

    @Inject
    private SamochodDAO samochodDAO;

    private List<Samochod> wszystkieSamochody;
    private Samochod nowySamochod = new Samochod();
    private Samochod edytowanySamochod;

    public List<Samochod> getWszystkieSamochody() {
        if (wszystkieSamochody == null) {
            wszystkieSamochody = samochodDAO.findAll();
        }
        return wszystkieSamochody;
    }

    public void setWszystkieSamochody(List<Samochod> wszystkieSamochody) {
        this.wszystkieSamochody = wszystkieSamochody;
    }

    public Samochod getNowySamochod() {
        return nowySamochod;
    }

    public void setNowySamochod(Samochod nowySamochod) {
        this.nowySamochod = nowySamochod;
    }

    public Samochod getEdytowanySamochod() {
        return edytowanySamochod;
    }

    public void setEdytowanySamochod(Samochod edytowanySamochod) {
        this.edytowanySamochod = edytowanySamochod;
    }

    public void prepareForEdit(Samochod samochod) {
        this.edytowanySamochod = samochod;
    }

    public String dodajSamochod() {
        try {
            samochodDAO.create(nowySamochod);
            nowySamochod = new Samochod();
            wszystkieSamochody = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String zapiszZmiany() {
        try {
            samochodDAO.update(edytowanySamochod);
            edytowanySamochod = null;
            wszystkieSamochody = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String usunSamochod(Integer id) {
        try {
            samochodDAO.delete(id);
            wszystkieSamochody = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
