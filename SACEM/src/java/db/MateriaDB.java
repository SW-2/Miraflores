/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

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
public class MateriaDB {
    private Session ss;

    public MateriaDB() {
        this.ss = HibernateUtil.getSessionFactory().openSession();
        //this.ss = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public ArrayList<Materia> buscarTodo(){
        ArrayList<Materia> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Materia>) this.ss.createQuery("from Clases.Materia").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener Materias    "+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Materia> buscarPorNombre(String query){
        ArrayList<Materia> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Materia>) this.ss.createQuery("from Clases.Materia where mat_nombre like '"+query+"%'").list();
            tx.commit();
            this.ss.close();
            return ret;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener Materias    "+e.getMessage());
            return null;
        }
    }
    
    public Materia buscarUnica(String id){
        ArrayList<Materia> ret = null;
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            ret = (ArrayList<Materia>) this.ss.createQuery("from Clases.Materia where mat_id ="+id).list();
            tx.commit();
            this.ss.close();
            return ret.get(0);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en obtener Materias unica   "+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Materia> buscarPorCurso(String curso){
        ArrayList<Materia> mats = new ArrayList<Materia>();
        CursoMateriaDB cmdb = new CursoMateriaDB();
        ArrayList<CursoMateria> curmat = cmdb.buscarPorCursoParalelo(curso);
        for(CursoMateria cm: curmat ){
            int id = cm.getMateria().getMatId();
            mats.add(buscarUnica(""+id));
        }
        return mats;
    }
    
}
