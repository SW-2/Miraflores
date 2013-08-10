/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Clases.HibernateUtil;
import Clases.Parentesco;
import Clases.Seccion;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Garcia
 */
public class ParentescoDB {
    private Session ss;

    public ParentescoDB() {
        this.ss = HibernateUtil.getSessionFactory().openSession();
        //this.ss = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public Parentesco obtenerUnica(String id){
        ArrayList<Parentesco> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
                
            Transaction tx = this.ss.beginTransaction();
                
            ret = (ArrayList<Parentesco>) this.ss.createQuery("from Clases.Parentesco where par_id="+id).list();
            tx.commit();
            this.ss.close();
            return ret.get(0);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener SECCION    "+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Parentesco> obtenerTodas(){
        ArrayList<Parentesco> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
                
            Transaction tx = this.ss.beginTransaction();
                
            ret = (ArrayList<Parentesco>) this.ss.createQuery("from Clases.Parentesco").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener TODAS LAS Parentesco    "+e.getMessage());
            return null;
        }
    }
    
}
