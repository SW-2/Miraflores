/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Clases.HibernateUtil;
import Clases.PadreFamilia;
import Clases.Parentesco;
import Clases.Persona;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Garcia
 */
public class PadreFamiliaDB {
    private Session ss;

    public PadreFamiliaDB() {
        this.ss = HibernateUtil.getSessionFactory().openSession();
        //this.ss = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public boolean guardarRelacion(Persona padre, Persona hijo, Parentesco rel, boolean representante){
        PadreFamilia pf = new PadreFamilia();
        try{
            if(!this.ss.isOpen())
                this.ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = this.ss.beginTransaction();
            pf.setFamiliar(padre.getPerId());
            pf.setPersonaByEstudiante(hijo);
            pf.setParentesco(rel);
            pf.setRepresentante(representante);
            this.ss.save(pf);
            tx.commit();
            //aqui ya tengo el id del man q se guardo!!
            this.ss.close();
            return true;
        }catch(Exception e){
            System.out.println("En guardar persona relacion - "+e.getMessage()+" - - ");
            return false;
        }
    }
}
