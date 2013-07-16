/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Estudiante;
import Clases.Persona;
import db.EstudianteDB;
import db.PersonaDB;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Jorge Garcia
 */
public class EstudianteLogic {
    EstudianteDB edb;
    PersonaDB pdb;

    public EstudianteLogic() {
        edb = new EstudianteDB();
        pdb = new PersonaDB();
    }
    
    public Estudiante obtenerUnico(String id){
        return edb.buscarUnico(id);
    }
    
    public boolean guardarEstudiante(String direccion, String cedula, String nombres, String apellidos, String sexo, String telefono, String celular, String email, String fecha){
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(fecha);
            Date datein = new Date();
            //System.out.println("FECHA RECIBIDA -----> "+date.toString());
            Persona p = new Persona(0, direccion, nombres, apellidos, date, sexo.charAt(0), telefono, celular, email, cedula);
            if(pdb.guardarPersona(p) != 0){
                return edb.guardarEstudiante(p, datein);
            }
            else return false;
        }catch (Exception e){
            System.out.println("En persona logic guardar - "+e.getMessage());
            return false;
        }
    }
    
    public boolean guardarEstudiante2(Persona p){
        try{
            Date datein = new Date();
            System.out.println("La persona "+p.getPerId()+" ahora es estudiante");
            return edb.guardarEstudiante(p, datein);
        }catch(Exception e){
            System.out.println("En Estudiante logic guardar - "+e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Estudiante> obtenerTodos(){
        return edb.buscarTodo();
    }
}
