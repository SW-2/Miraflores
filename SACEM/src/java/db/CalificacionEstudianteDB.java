/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Clases.CalificacionEstudiante;
import Clases.HibernateUtil;
import Clases.Persona;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Garcia
 */
public class CalificacionEstudianteDB {
    private Session ss;

    public CalificacionEstudianteDB() {
        this.ss = HibernateUtil.getSessionFactory().openSession();
    }
    
    public ArrayList<CalificacionEstudiante> obtenerPorCursoMateria(String curmat){
        ArrayList<CalificacionEstudiante> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<CalificacionEstudiante>) this.ss.createQuery("from Clases.CalificacionEstudiante where curmat_id="+curmat).list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener Calificacion por curso y materia"+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<CalificacionEstudiante> obtenerPorCursoMateriaParcial(String curmat, String parcial){
        ArrayList<CalificacionEstudiante> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<CalificacionEstudiante>) this.ss.createQuery("from Clases.CalificacionEstudiante where curmat_id="+curmat+" and parc_id="+parcial).list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener Calificacion por curso y materia"+e.getMessage());
            return null;
        }
    }
}
