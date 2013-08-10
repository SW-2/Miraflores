/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Clases.HibernateUtil;
import Clases.Persona;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Garcia
 */
public class PersonaDB {
    private Session ss;

    public PersonaDB() {
        this.ss = HibernateUtil.getSessionFactory().openSession();
        //this.ss = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public ArrayList<Persona> buscarTodo(){
        ArrayList<Persona> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Persona>) this.ss.createQuery("from Clases.Persona").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener personas    "+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Persona> buscarXCedula(String cedula){
        ArrayList<Persona> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Persona>) this.ss.createQuery("from Clases.Persona where per_cedula="+cedula).list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener personas    "+e.getMessage());
            return null;
        }
    }
    
    public Persona buscarUnico(String id){
        ArrayList<Persona> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Persona>) this.ss.createQuery("from Clases.Persona where per_id="+id).list();
            tx.commit();
            this.ss.close();
            return ret.get(0);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener persona unica    "+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Persona> buscarXApellidos(String apellidos){
        ArrayList<Persona> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Persona>) this.ss.createQuery("from Clases.Persona where per_apellidos like '"+apellidos+"%'").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener personas    "+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Persona> buscarXApellidosYNombres(String apellidos, String nombres){
        ArrayList<Persona> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Persona>) this.ss.createQuery("from Clases.Persona where per_apellidos = '"+apellidos+"' and per_nombres='"+nombres+"'").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener personas    "+e.getMessage());
            return null;
        }
    }
    
    public int guardarPersona(Persona p){
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            System.out.println(p.getPerCedula());
            this.ss.save(p);
            tx.commit();
            //aqui ya tengo el id del man q se guardo!!
            this.ss.close();
            return p.getPerId();
        }catch(Exception e){
            System.out.println("En guardar persona DB - "+e.getMessage()+" - - ");
            return 0;
        }
    }
    
}
