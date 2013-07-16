/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Clases.HibernateUtil;
import Clases.Seccion;
import java.io.Serializable;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Garcia
 */
public class SeccionDB implements Serializable{
    private Session ss;

    public SeccionDB() {
        this.ss = HibernateUtil.getSessionFactory().openSession();
        //this.ss = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public Seccion obtenerUnica(String id){
        ArrayList<Seccion> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
                
            Transaction tx = this.ss.beginTransaction();
                
            ret = (ArrayList<Seccion>) this.ss.createQuery("from Clases.Seccion where sec_id="+id).list();
            tx.commit();
            this.ss.close();
            return ret.get(0);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener SECCION    "+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Seccion> obtenerTodas(){
        ArrayList<Seccion> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
                
            Transaction tx = this.ss.beginTransaction();
                
            ret = (ArrayList<Seccion>) this.ss.createQuery("from Clases.Seccion").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener TODAS LAS SECCIONES    "+e.getMessage());
            return null;
        }
    }
    
}
