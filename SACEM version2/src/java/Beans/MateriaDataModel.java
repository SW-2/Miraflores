/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Materia;
import Clases.Persona;
import java.util.List;  
import javax.faces.model.ListDataModel;  
import org.primefaces.model.SelectableDataModel;  
/**
 *
 * @author PC
 */
public class MateriaDataModel extends ListDataModel<Materia> implements SelectableDataModel<Materia>{

    /**
     * Creates a new instance of MateriaDataModel
     */
    public MateriaDataModel() {
    }
    
    public MateriaDataModel(List<Materia> data) {
        super(data);
    }
    
    @Override  
    public Materia getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        List<Materia> materias = (List<Materia>) getWrappedData();  
          
        for(Materia materia : materias) {  
            if((""+materia.getMatId()).equals(rowKey))  
                return materia;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(Materia materia) {  
        return materia.getMatId();
    } 
}
