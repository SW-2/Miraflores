/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Seccion;
import db.SeccionDB;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Jorge Garcia
 */
public class SeccionLogic implements Serializable{
    SeccionDB sdb;

    public SeccionLogic() {
        sdb = new SeccionDB();
    }
    
    public Seccion obtenerUnico(String id){
        return sdb.obtenerUnica(id);
    }
    
    public ArrayList<Seccion> obtenerTodas(){
        return sdb.obtenerTodas();
    }
    
}
