/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Materia;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import logica.MateriaLogic;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Jorge Garcia
 */
@ManagedBean
@ViewScoped
public class MateriaBean implements Serializable{
    private String query;
    private Materia selected;
    DataModel results;
    MateriaLogic ml;
    /**
     * Creates a new instance of MateriaBean
     */
    public MateriaBean(){
        
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Materia getSelected() {
        return selected;
    }

    public void setSelected(Materia selected) {
        this.selected = selected;
    }

    public DataModel getResults() {
        return results;
    }

    public void setResults(DataModel results) {
        this.results = results;
    }

    public MateriaLogic getMl() {
        return ml;
    }

    public void setMl(MateriaLogic ml) {
        this.ml = ml;
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Materia Seleccionada", ((Materia) event.getObject()).getMatId()+" "+((Materia) event.getObject()).getMatNombre());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    public void search(){
        System.out.println("MATERIA A BUSCAR -------------->"+query);
        ml = new MateriaLogic();
        results = new ListDataModel(ml.buscarPorNombre(query));
    }
    
    public void onRowUnselect(UnselectEvent event) {  
        FacesMessage msg = new FacesMessage("Materia Seleccionada", ((Materia) event.getObject()).getMatNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
