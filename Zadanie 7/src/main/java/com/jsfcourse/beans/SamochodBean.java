package com.jsfcourse.beans;

import com.jsfcourse.dao.SamochodDAO;
import com.jsfcourse.entities.Samochod;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named("samochodBean")
@RequestScoped 
public class SamochodBean {

    @Inject
    private SamochodDAO samochodDAO;

    private List<Samochod> samochody;

    @PostConstruct
    public void init() {
        samochody = samochodDAO.findAll();
    }

    public List<Samochod> getSamochody() {
        return samochody;
    }
}
