/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Persona;
import Clases.Profesor;
import db.PersonaDB;
import db.ProfesorDB;
import java.util.Date;

/**
 *
 * @author Jorge Garcia
 */
public class ProfesorLogic {
    ProfesorDB profdb;
    PersonaDB perdb;

    public ProfesorLogic() {
        this.profdb = new ProfesorDB();
        this.perdb = new PersonaDB();
    }
    
    public Profesor obtenerUnico(String id){
        return profdb.buscarUnico(id);
    }
    
    public boolean guardarProfesor2(Persona p){
        Profesor prof = new Profesor();
        prof.setPerId(p.getPerId());
        prof.setProfFechaIngreso("15-05-2004");
        prof.setProfTitulo("Licenciado");
        try{
            Date datein = new Date();
            System.out.println("La persona "+p.getPerId()+" ahora es profesor");
            return profdb.guardarProfesor(prof);
        }catch(Exception e){
            System.out.println("En Estudiante logic guardar - "+e.getMessage());
            return false;
        }
    }
    
}
