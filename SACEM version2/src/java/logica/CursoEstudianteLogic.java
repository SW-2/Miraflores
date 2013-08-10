/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Curso;
import Clases.CursoEstudiante;
import Clases.Estudiante;
import db.CursoEstudianteDB;
import java.util.ArrayList;

/**
 *
 * @author Jorge Garcia
 */
public class CursoEstudianteLogic {
    CursoEstudianteDB cedb;

    public CursoEstudianteLogic() {
        cedb = new CursoEstudianteDB();
    }
    
    public boolean guardar(String estId, String curId){
        
        CursoLogic cl = new CursoLogic();
        Curso c = cl.buscarUnico(curId);
        
        EstudianteLogic el = new EstudianteLogic();
        Estudiante e = el.obtenerUnico(estId);
        
        if(!buscarPorEstudiante(estId, "2013").isEmpty())
            return false;
        
        CursoEstudiante ce = new CursoEstudiante(0,e, c);
        
        return cedb.guardar(ce);
    }
    
    public ArrayList<CursoEstudiante> buscarPorCurso(String curso){
        return cedb.buscarPorCurso(curso);    
    }
    
    public ArrayList<CursoEstudiante> buscarPorEstudiante(String id, String anio){
        return cedb.buscarPorEstudiante(id, anio);
    }
    
}
