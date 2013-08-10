/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Clases.Curso;
import Clases.HibernateUtil;
import Clases.Materia;
import Clases.Persona;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Garcia
 */
public class CursoDB {
    private Session ss;

    public CursoDB() {
        this.ss = HibernateUtil.getSessionFactory().openSession();
    }
    
    public ArrayList<Curso> buscarTodo(){
        ArrayList<Curso> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Curso>) this.ss.createQuery("from Clases.Curso").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// Error en obtener todos los cursos    "+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Curso> buscarPorSeccion(String s){
        ArrayList<Curso> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Curso>) this.ss.createQuery("from Clases.Curso where sec_id="+s+"and cur_paralelo='A' order by cur_nombre asc").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// Error en obtener todos los cursos por seccion    "+e.getMessage());
            return null;
        }
    }
    
    public boolean crearParalelo(Curso c){
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ss.save(c);
            tx.commit();
            this.ss.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// Error en CREAR PARALELO       "+e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Curso> buscarParalelos(String seccion, String curso){
        ArrayList<Curso> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Curso>) this.ss.createQuery("from Clases.Curso where cur_nombre="+curso+" and sec_id="+seccion+" order by cur_paralelo asc").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// Error en obtener todos los cursos por seccion    "+e.getMessage());
            return null;
        }
    }
    
    public Curso buscarCursoSeccionParalelo(String seccion, String curso, String paralelo){
        ArrayList<Curso> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Curso>) this.ss.createQuery("from Clases.Curso where cur_nombre="+curso+" and sec_id="+seccion+" and cur_paralelo='"+paralelo+"'").list();
            tx.commit();
            this.ss.close();
            return ret.get(0);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// Error en obtener todos los cursos por seccion    "+e.getMessage());
            return null;
        }
    }
    
    
    public Curso buscarUnico(String id){
        ArrayList<Curso> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Curso>) this.ss.createQuery("from Clases.Curso where cur_id="+id).list();
            tx.commit();
            this.ss.close();
            return ret.get(0);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// Error en obtener unico curso     /////////"+e.getMessage());
            return null;
        }
    }
    
    
    public boolean guardarParalelo(Curso c){
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            this.ss.save(c);
            tx.commit();
            this.ss.close();
            return true;
        }catch(Exception e){
            System.out.println("En guardar curso, nuevo paralelo - "+e.getMessage()+" - - ");
            return false;
        }
    }
    
}
