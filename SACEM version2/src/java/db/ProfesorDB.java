/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Clases.Estudiante;
import Clases.HibernateUtil;
import Clases.Persona;
import Clases.Profesor;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Garcia
 */
public class ProfesorDB {
    private Session ss;
    
    public ProfesorDB() {
        this.ss = HibernateUtil.getSessionFactory().openSession();
        //this.ss = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public ArrayList<Profesor> buscarTodo(){
        ArrayList<Profesor> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Profesor>) this.ss.createQuery("from Clases.Profesor").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener Profesor -    "+e.getMessage());
            return null;
        }
    }
    
    public Profesor buscarUnico(String id){
        ArrayList<Profesor> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Profesor>) this.ss.createQuery("from Clases.Profesor where per_id="+id).list();
            tx.commit();
            this.ss.close();
            return ret.get(0);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener Profesor unico    /////"+e.getMessage());
            return null;
        }
    }
    
    public boolean guardarProfesor(Profesor p){
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            this.ss.save(p);
            tx.commit();
            this.ss.close();
            return true;
        }catch(Exception e){
            System.out.println("En guardar Profesor DB - "+e.getMessage()+" - - ");
            return false;
        }
    }
}
