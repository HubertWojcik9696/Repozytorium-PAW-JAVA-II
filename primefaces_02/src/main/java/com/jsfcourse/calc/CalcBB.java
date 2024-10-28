package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;


@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	private String kwota;
	private String procent;
	private String lata;
	private Double rata;

	@Inject
	FacesContext ctx;

	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public String getProcent() {
		return procent;
	}

	public void setProcent(String procent) {
	    this.procent = procent;
	}
	
	public String getLata() {
        return lata;
    }
	public void setLata(String lata) {
	    this.lata = lata;
	}
    public Double getRata() {
        return rata;
    }
    public void rata(Double rata) {
        this.rata = rata;
    }

    public boolean doTheMath() {
        try {
            double k = Double.parseDouble(this.kwota); 
            double o = Double.parseDouble(this.procent) / 100 / 12; 
            int miesiac = Integer.parseInt(this.lata) * 12; 

            if (miesiac == 0) {
                rata = 0.0; 
            } else {
                double wynik = k * o / (1 - Math.pow(1 + o, -miesiac)); 
                rata = BigDecimal.valueOf(wynik).setScale(2, RoundingMode.HALF_UP).doubleValue();
            }

            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
            return true;
        } catch (Exception e) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
            return false;
        }
    }

	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

	public String calc_AJAX() {
		if (doTheMath()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wynik: " + rata, null));
		}
		return null;
	}

	public String info() {
		return "info";
	}
}
