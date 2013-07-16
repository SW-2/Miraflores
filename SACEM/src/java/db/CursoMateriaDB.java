/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Clases.Curso;
import Clases.CursoMateria;
import Clases.HibernateUtil;
import Clases.Materia;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Garcia
 */
public class CursoMateriaDB {
    private Session ss;

    public CursoMateriaDB() {
        this.ss = HibernateUtil.getSessionFactory().openSession();
        //this.ss = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public ArrayList<CursoMateria> buscarPorCursoParalelo(String curso){
        ArrayList<CursoMateria> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<CursoMateria>) this.ss.createQuery("from Clases.CursoMateria where cur_id="+curso).list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener Materias   por curso  "+e.getMessage());
            return null;
        }
    }
    
    public boolean guardarSinProf(Curso c, Materia m){
        CursoMateria cm = new CursoMateria();
        cm.setCurso(c);
        cm.setMateria(m);
        cm.setCurmatId(0);
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            System.out.println("guardando curso- materia");
            this.ss.save(cm);
            tx.commit();
            this.ss.close();
            return true;
        }catch(Exception e){
            System.out.println("En guardar curso materia DB - "+e.getMessage()+" - - ");
            return false;
        }
    }
    
    public CursoMateria buscarUnica(String curso, String materia){
        ArrayList<CursoMateria> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<CursoMateria>) this.ss.createQuery("from Clases.CursoMateria where cur_id="+curso+"and mat_id="+materia).list();
            tx.commit();
            this.ss.close();
            return ret.get(0);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener Materias   por curso  "+e.getMessage());
            return null;
        }
        
    }
}
