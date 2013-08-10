/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Persona;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import logica.CursoEstudianteLogic;
import logica.PersonaLogic;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Jorge Garcia
 */
@ManagedBean
@SessionScoped
public class RepresentanteBean {

    private String query;
    private Persona selectedPersona;
    DataModel results;
    PersonaLogic pl;
    /**
     * Creates a new instance of RepresentanteBean
     */
    public RepresentanteBean() {
        pl = new PersonaLogic();
        selectedPersona = new Persona();
    }
    public DataModel getResults() {
        if (results == null) {
            search();
        }
        return results;
    }
    
    public String getQuery(){
        return query;
    }
    
    public void setQuery(String s){
        this.query = s;
    }

    public Persona getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(Persona selectedPersona) {
        this.selectedPersona = selectedPersona;
    }
    
    public void search(){
        System.out.println("APELLIDO A BUSCAR -------------->"+query);
        pl = new PersonaLogic();
        results = new ListDataModel(pl.buscarPorApellidos(query));
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Persona Seleccionada", ((Persona) event.getObject()).getPerApellidos()+" "+((Persona) event.getObject()).getPerNombres()  );  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    public void onRowUnselect(UnselectEvent event) {  
        FacesMessage msg = new FacesMessage("Persona Seleccionada", ((Persona) event.getObject()).getPerCedula());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void relacionar(Persona per) {  
        FacesMessage msg = new FacesMessage("Selected", "Representante:" + selectedPersona.getPerApellidos() + ", Estudiante: " + per.getPerApellidos());  
        System.out.println("La persona con cedula #"+selectedPersona.getPerApellidos()+" representante de: "+per.getPerApellidos());
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
    
    
}
