/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Materia;
import db.MateriaDB;
import java.util.ArrayList;

/**
 *
 * @author Jorge Garcia
 */
public class MateriaLogic {
    MateriaDB mdb;

    public MateriaLogic() {
        mdb = new MateriaDB();
    }
    
    public ArrayList<Materia> buscarTodo(){
        return mdb.buscarTodo();
    }
    
    public ArrayList<Materia> buscarPorNombre(String query){
        return mdb.buscarPorNombre(query);
    }
    
    public Materia buscarUnica(String id){
        return mdb.buscarUnica(id);
    }
    
    public ArrayList<Materia> buscarPorCurso(String curso){
        return mdb.buscarPorCurso(curso);
    }
}
