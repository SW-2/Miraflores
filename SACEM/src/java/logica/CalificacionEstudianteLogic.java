/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.CalificacionEstudiante;
import db.CalificacionEstudianteDB;
import java.util.ArrayList;

/**
 *
 * @author Jorge Garcia
 */
public class CalificacionEstudianteLogic {
    CalificacionEstudianteDB cedb;

    public CalificacionEstudianteLogic() {
        cedb = new CalificacionEstudianteDB();
    }
    
    public ArrayList<CalificacionEstudiante> obtenerPorCursoMateriaParcial(String curmat, String parcial){
        return cedb.obtenerPorCursoMateriaParcial(curmat, parcial);
    }
    
    
}
