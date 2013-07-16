/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jorge Garcia
 */
@ManagedBean
@ViewScoped
public class FechaBean {

    private Map<String,String> anios = new HashMap<String, String>();  
    private Map<String,String> meses = new HashMap<String, String>();  
    private Map<String,String> dias = new HashMap<String, String>();  
    /**
     * Creates a new instance of FechaBean
     */
    public FechaBean() {
        
    }

    public Map<String, String> getAnios() {
        return anios;
    }

    public void setAnios(Map<String, String> anios) {
        this.anios = anios;
    }

    public Map<String, String> getMeses() {
        return meses;
    }

    public void setMeses(Map<String, String> meses) {
        this.meses = meses;
    }

    public Map<String, String> getDias() {
        return dias;
    }

    public void setDias(Map<String, String> dias) {
        this.dias = dias;
    }
    
}
