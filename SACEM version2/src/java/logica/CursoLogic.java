/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Curso;
import Clases.Seccion;
import db.CursoDB;
import java.util.ArrayList;

/**
 *
 * @author Jorge Garcia
 */
public class CursoLogic {
    CursoDB cdb;

    public CursoLogic() {
        cdb = new CursoDB();
    }
    
    public ArrayList<Curso> buscarTodos(){
        return cdb.buscarTodo();
    }
    
    public ArrayList<Curso> buscarPorSeccion(String seccion){
        return cdb.buscarPorSeccion(seccion);
    }
    
    public Curso buscarUnico(String id){
        return cdb.buscarUnico(id);
    }
    
    public boolean crearParalelo(String seccion, String curso, String ultimoPar){
        Curso c = new Curso();
        c.setCurNombre(Integer.parseInt(curso));
        c.setCurEspecialidad("");
        c.setCurAnioLectivo(2013);
        c.setCurCupo("100");
        c.setSeccion(new Seccion(Integer.parseInt(seccion)));
        char par = ultimoPar.charAt(0);
        c.setCurParalelo((char)(par+1));
        return cdb.crearParalelo(c);
        
    }
    
    public ArrayList<String> obtenerParalelos(String seccion, String curso){
        ArrayList<Curso> cursos = cdb.buscarParalelos(seccion, curso);
        ArrayList<String> ret = new ArrayList<String>();
        for(Curso c: cursos){
            ret.add(""+c.getCurParalelo());
        }
        if(!ret.isEmpty())
            return ret;
        else return null;
    }
    
    public Curso buscarCursoSeccionParalelo(String seccion, String curso, String paralelo){
        return cdb.buscarCursoSeccionParalelo(seccion, curso, paralelo);
    }
}
