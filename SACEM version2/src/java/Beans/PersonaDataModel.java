/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Persona;
import java.util.List;  
import javax.faces.model.ListDataModel;  
import org.primefaces.model.SelectableDataModel;  
  
public class PersonaDataModel extends ListDataModel<Persona> implements SelectableDataModel<Persona> {    
  
    public PersonaDataModel() {  
    }  
  
    public PersonaDataModel(List<Persona> data) {  
        super(data);  
    }  
      
    @Override  
    public Persona getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        List<Persona> personas = (List<Persona>) getWrappedData();  
          
        for(Persona persona : personas) {  
            if(persona.getPerCedula().equals(rowKey))  
                return persona;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(Persona persona) {  
        return persona.getPerCedula();  
    }  
}  