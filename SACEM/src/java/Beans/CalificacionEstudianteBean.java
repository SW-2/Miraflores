/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Persona;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jorge Garcia
 */
@ManagedBean
@ViewScoped
public class CalificacionEstudianteBean {
    PersonaDataModel results;
    private Persona selectedPersona;
    /**
     * Creates a new instance of CalificacionEstudianteBean
     */
    public CalificacionEstudianteBean() {
    }

    public PersonaDataModel getResults() {
        return results;
    }

    public void setResults(PersonaDataModel results) {
        this.results = results;
    }

    public Persona getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(Persona selectedPersona) {
        this.selectedPersona = selectedPersona;
    }
    
}
