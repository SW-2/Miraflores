/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Garcia
 */
public class main {
    public static void main(String[] args){
       
        
        
        Session ss=HibernateUtil.getSessionFactory().openSession();
        try{
            if(!ss.isOpen())
                ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = ss.beginTransaction();
            
            Connection con = HibernateUtil.getSessionFactory().getCurrentSession().connection();
/**
* Amend to include your parameters and proc
*/          
            CallableStatement cs = con.prepareCall( "{ call sp_prueba ?}");
            cs.setString(1, "20");

            cs.execute();
            
            
            tx.commit();
            ss.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("///////////// error en main por curso  "+e.getMessage());
        }
        //pa materias por curso
        /*
        CursoMateriaLogic cml = new CursoMateriaLogic();
        cml.guardarSinProf("18", "9");
        */
        // para registrar un alumno en un curso
        
        /*
        CursoLogic cl = new CursoLogic();
        Curso c = cl.buscarCursoSeccionParalelo("1", "24", "A");
        System.out.println("///////////// CURSO:  "+c.getCurNombre());
        */
        // registrar persona como estudiante
         /*
        PersonaLogic pl = new PersonaLogic();
        EstudianteLogic el = new EstudianteLogic();
        el.guardarEstudiante2(pl.buscarTodo().get(1));
        */
        /*
        CursoLogic cl = new CursoLogic();
        ArrayList<Curso> lista = cl.buscarPorSeccion("1");
        SeccionLogic sl = new SeccionLogic();
        int i=0;
        String id;
        while(lista.get(i) != null){
            id = ""+lista.get(i).getSeccion().getSecId();
            
            System.out.println("///////////// CURSO:  "+lista.get(i).getCurNombre());
            System.out.println("////////////////// SECCION:  "+sl.obtenerUnico(id).getSecNombre());
            i++;
        }
        
        
        
        MateriaLogic ml = new MateriaLogic();
        ArrayList<Materia> materias = ml.buscarTodo();
        
        int i=0;
        
        while(materias.get(i) != null){
            System.out.println("//////////  "+materias.get(i).getMatId()+" /// "+materias.get(i).getMatNombre());
            i++;
        }
        
        
        
        PersonaLogic pl = new PersonaLogic();
        
        try{
            Date date = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse("24-05-2012");
            System.out.println(date.toString());
        }catch (Exception e){
            System.out.println("En persona logic guardar - "+e.getMessage());
        }
        
        
        //pl.guardarPersona("direcion de muestra", "0945687958", "vanessa veronica", "alvarado paucar", "F", "1254857", "0954856584", "hyvbouboeub@OUBOUBO.com", "24-09-2012");
        
        ArrayList<Persona> lista = pl.buscarPorApellidos("e");
        
        int i=0;
        
        while(lista.get(i) != null){
            System.out.println("//////////  "+lista.get(i).getPerCedula()+" /// "+lista.get(i).getPerApellidos());
            i++;
        }*/
    }
    
}
