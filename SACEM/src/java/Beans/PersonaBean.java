/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Estudiante;
import Clases.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logica.EstudianteLogic;
import logica.PadreFamiliaLogic;
import logica.PersonaLogic;
import logica.ProfesorLogic;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Jorge Garcia
 */
@ManagedBean
@SessionScoped
public class PersonaBean implements Serializable{

    private String query;
    private Persona selectedPersona;
    private Persona nuevoEstudiante;
    private Persona nuevoRepresentante;
    PersonaDataModel results;
    PersonaLogic pl;
    /**
     * Creates a new instance of personaController
     */
    public PersonaBean(){
        pl = new PersonaLogic();
        nuevoEstudiante = new Persona();
        nuevoRepresentante = new Persona();
    }

    public Persona getNuevoEstudiante() {
        return nuevoEstudiante;
    }

    public void setNuevoEstudiante(Persona nuevoEstudiante) {
        this.nuevoEstudiante = nuevoEstudiante;
    }

    public Persona getNuevoRepresentante() {
        return nuevoRepresentante;
    }

    public void setNuevoRepresentante(Persona nuevoRepresentante) {
        this.nuevoRepresentante = nuevoRepresentante;
    }
    
    
    
    public PersonaDataModel getResults() {
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
        EstudianteLogic el = new EstudianteLogic();
        
        ArrayList<Estudiante> ests = el.obtenerTodos();
        ArrayList<Persona> pers = new ArrayList<Persona>();
        ArrayList<Persona> pers2 = pl.buscarPorApellidos(query);
        for(Persona p: pers2){
            for(Estudiante e: ests){
                if(e.getPerId() == p.getPerId())
                    pers.add(p);
            }
        }
        results = new PersonaDataModel(pers);
    }
    
     
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Persona Seleccionada", ((Persona) event.getObject()).getPerApellidos()+" "+((Persona) event.getObject()).getPerNombres()  );  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    public void onRowUnselect(UnselectEvent event) {  
        FacesMessage msg = new FacesMessage("Persona Seleccionada", ((Persona) event.getObject()).getPerCedula());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void hacerEstudiante(){
        EstudianteLogic el = new EstudianteLogic();
        System.out.println("en hacer estudiante -------------");
        el.guardarEstudiante2(selectedPersona);
    }
    
    public void hacerProfesor(){
        ProfesorLogic pl = new ProfesorLogic();
        System.out.println("en hacer Profesor -------------");
        pl.guardarProfesor2(selectedPersona);
    }
    
    public void guardarNuevo(String parent){
        EstudianteLogic el = new EstudianteLogic();
        PadreFamiliaLogic pfl = new PadreFamiliaLogic();
        
        System.out.println("estudiante: "+nuevoEstudiante.getPerApellidos());
        System.out.println("representante: "+nuevoRepresentante.getPerApellidos());
        System.out.println("PArentesco: "+parent);
        int estId = pl.guardarPersona2(nuevoEstudiante);
        int repId = pl.guardarPersona2(nuevoRepresentante);
        if( estId != 0){
            if(repId != 0){
                //estan registradas las 2 personas
                el.guardarEstudiante2(pl.buscarUnica(""+estId));
                if(pfl.guardarRelacion(""+repId, ""+estId, parent)){
                    System.out.println("Se guardo correctamente la relacion");
                    nuevoEstudiante=new Persona();
                    nuevoRepresentante=new Persona();
                    FacesMessage msg = new FacesMessage("Selected", "Se guardo correctamente");  
                    FacesContext.getCurrentInstance().addMessage(null, msg);  
                    RequestContext.getCurrentInstance().update("body:tabView:tab1:formnu");
                }
            }
        }
    }
    
    public void hazAlgo(){
        System.out.println("estudiante: "+nuevoEstudiante.getPerNombres());
    }
}
