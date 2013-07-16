/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Curso;
import Clases.CursoMateria;
import Clases.Materia;
import db.CursoMateriaDB;
import java.util.ArrayList;

/**
 *
 * @author Jorge Garcia
 */
public class CursoMateriaLogic {
    CursoMateriaDB cmdb;

    public CursoMateriaLogic() {
        cmdb = new CursoMateriaDB();
    }
    
    public boolean guardarSinProf(String cursoId, String materiaId){
        MateriaLogic ml = new MateriaLogic();
        CursoLogic cl = new CursoLogic();
        
        Materia m = ml.buscarUnica(materiaId);
        Curso c = cl.buscarUnico(cursoId);
        
        return cmdb.guardarSinProf(c, m);
    }
    
    public ArrayList<CursoMateria> buscarPorCursoParalelo(String curso){
        return cmdb.buscarPorCursoParalelo(curso);
    }
    
    public CursoMateria buscarUnica(String curso, String materia){
        return cmdb.buscarUnica(curso, materia);
    }
    
}
