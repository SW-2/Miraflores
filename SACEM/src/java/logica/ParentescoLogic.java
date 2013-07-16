/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Parentesco;
import db.ParentescoDB;
import java.util.ArrayList;

/**
 *
 * @author Jorge Garcia
 */
public class ParentescoLogic {
    ParentescoDB pdb;

    public ParentescoLogic() {
        pdb = new ParentescoDB();
    }
    
    public Parentesco obtenerUnica(String id){
        return pdb.obtenerUnica(id);
    }
    
    public ArrayList<Parentesco> obtenerTodas(){
        return pdb.obtenerTodas();
    }
    
}
