package com.jsfcourse.calc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ResourceBundle;

import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class CalcBB implements Serializable {
	private String kwota;
	private String procent;
	private String lata;
	private Double rata;

	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalcErr}")
	private ResourceBundle txtCalcErr;

	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalc}")
	private ResourceBundle txtCalc;

	@Inject
	FacesContext ctx;
	
	// Resource loaded "manually"
	// (here after initialization in @PostConstruct method)
	// (locale explicitly given - here based on the view )
//	@PostConstruct
//	public void postConstruct() {
//		// loading resource (notice the full "file" name)
//		txtCalc = ResourceBundle.getBundle("resources.textCalc", ctx.getViewRoot().getLocale());
//		txtCalcErr = ResourceBundle.getBundle("resources.textCalcErr", ctx.getViewRoot().getLocale());
//	}
	
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