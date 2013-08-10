/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Clases.Estudiante;
import Clases.HibernateUtil;
import Clases.Persona;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Garcia
 */
public class EstudianteDB {
    private Session ss;
    
    public EstudianteDB() {
        this.ss = HibernateUtil.getSessionFactory().openSession();
        //this.ss = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public ArrayList<Estudiante> buscarTodo(){
        ArrayList<Estudiante> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Estudiante>) this.ss.createQuery("from Clases.Estudiante").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener Estudiante    "+e.getMessage());
            return null;
        }
    }
    
    public Estudiante buscarUnico(String id){
        ArrayList<Estudiante> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Estudiante>) this.ss.createQuery("from Clases.Estudiante where per_id="+id).list();
            tx.commit();
            this.ss.close();
            return ret.get(0);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener Estudiante unico    /////"+e.getMessage());
            return null;
        }
    }
    
    public boolean guardarEstudiante(Persona p, Date ingreso){
        Estudiante est = new Estudiante();
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            est.setPerId(p.getPerId());
            est.setPersona(p);
            est.setEstFechaIngreso(ingreso);
            this.ss.save(est);
            tx.commit();
            this.ss.close();
            return true;
        }catch(Exception e){
            System.out.println("En guardar Estudiante DB - "+e.getMessage()+" - - ");
            return false;
        }
    }
    
}
