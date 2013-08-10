/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.CalificacionEstudiante;
import Clases.Persona;
import java.util.List;
import javax.faces.model.ListDataModel;
import logica.PersonaLogic;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author Jorge Garcia
 */
public class CalificacionEstudianteDataModel extends ListDataModel<CalificacionEstudiante> implements SelectableDataModel<CalificacionEstudiante>,java.io.Serializable  {    
    public CalificacionEstudianteDataModel() {  
    }  
  
    public CalificacionEstudianteDataModel(List<CalificacionEstudiante> data) {  
        super(data);  
    }  
      
    @Override  
    public CalificacionEstudiante getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
        PersonaLogic pl = new PersonaLogic();
        Persona p;
        List<CalificacionEstudiante> ces = (List<CalificacionEstudiante>) getWrappedData();
        for(CalificacionEstudiante ce : ces) {
            p = pl.buscarUnica(""+ce.getEstudiante().getPerId());
            if(p.getPerCedula().equals(rowKey))  
                return ce;  
        }  
        return null;  
    }  
  
    @Override  
    public Object getRowKey(CalificacionEstudiante ce) {  
        return ce.getEstudiante().getPersona().getPerCedula();  
    }
    
}
