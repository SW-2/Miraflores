/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Clases.CursoEstudiante;
import Clases.HibernateUtil;
import Clases.Persona;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Garcia
 */
public class CursoEstudianteDB {
    private Session ss;

    public CursoEstudianteDB() {
        this.ss = HibernateUtil.getSessionFactory().openSession();
    }
    
    public boolean guardar(CursoEstudiante ce){
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            this.ss.save(ce);
            tx.commit();
            this.ss.close();
            return true;
        }catch(Exception e){
            System.out.println("En guardar CursoEstudianteDB - "+e.getMessage()+" - - ");
            return false;
        }
    }
    
    public ArrayList<CursoEstudiante> buscarPorCurso(String curso){
        ArrayList<CursoEstudiante> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<CursoEstudiante>) this.ss.createQuery("from Clases.CursoEstudiante where cur_id="+curso).list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener estudiantes por curso"+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<CursoEstudiante> buscarPorEstudiante(String est, String anio){
        ArrayList<CursoEstudiante> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<CursoEstudiante>) this.ss.createQuery("from Clases.CursoEstudiante where per_id="+est).list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener estudiantes por curso"+e.getMessage());
            return null;
        }
    }
}
