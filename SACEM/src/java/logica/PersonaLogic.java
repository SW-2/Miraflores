/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Persona;
import db.PersonaDB;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Jorge Garcia
 */
public class PersonaLogic implements Serializable{
    PersonaDB pdb;

    public PersonaLogic() {
        pdb = new PersonaDB();
    }
    
    public ArrayList<Persona> buscarTodo(){
        return pdb.buscarTodo();
    }
    
    public ArrayList<Persona> buscarPorApellidos(String apellidos){
        return pdb.buscarXApellidos(apellidos);
    }
    
    public Persona buscarUnica(String id){
        return pdb.buscarUnico(id);
    }
    
    public int guardarPersona(String direccion, String cedula, String nombres, String apellidos, String sexo, String telefono, String celular, String email, String fecha){
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(fecha);
            //System.out.println("FECHA RECIBIDA -----> "+date.toString());
            Persona p = new Persona(0, direccion, nombres, apellidos, date, sexo.charAt(0), telefono, celular, email, cedula);
            return pdb.guardarPersona(p);
        }catch (Exception e){
            System.out.println("En persona logic guardar - "+e.getMessage());
            return 0;
        }
    }
    
    public int guardarPersona2(Persona p){
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse("2000-01-01");
            p.setPerFechaNacimiento(date);
            //System.out.println("FECHA RECIBIDA -----> "+date.toString());
            return pdb.guardarPersona(p);
        }catch (Exception e){
            System.out.println("En persona logic guardar 2- "+e.getMessage());
            return 0;
        }
    }
}