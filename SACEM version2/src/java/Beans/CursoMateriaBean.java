/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Curso;
import Clases.CursoMateria;
import Clases.Materia;
import Clases.Seccion;
import db.CursoMateriaDB;
import db.MateriaDB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import logica.CursoLogic;
import logica.CursoMateriaLogic;
import logica.MateriaLogic;
import logica.SeccionLogic;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author PC
 */
@ManagedBean
@SessionScoped
public class CursoMateriaBean implements Serializable {  
  
    private TreeNode root;  
    private TreeNode selectedNode;  
    
    private Map<String,String> secciones1 = new HashMap<String, String>();
    private Map<String,String> secciones_rev = new HashMap<String, String>();
    private Map<String,String> cursos1 = new HashMap<String, String>();
    
    private String parametro;
    MateriaDataModel materiaDM;
  
    public CursoMateriaBean() {  
        root = new DefaultTreeNode("Root", null);  
        
        SeccionLogic sl = new SeccionLogic();
        CursoLogic cl = new CursoLogic();
        
        ArrayList<Seccion> secciones = sl.obtenerTodas();
        ArrayList<Curso> cursos = null;
        ArrayList<TreeNode> ss = new ArrayList<TreeNode>();
        ArrayList<TreeNode> cc = new ArrayList<TreeNode>();
        
        for(Seccion s: secciones){
            secciones1.put(""+s.getSecId(), s.getSecNombre());
            secciones_rev.put(s.getSecNombre(),""+s.getSecId());
            ss.add(new DefaultTreeNode(secciones1.get(""+s.getSecId()), root));
            //ss.add(new DefaultTreeNode(s, root));
            
            
            cursos = cl.buscarPorSeccion(""+s.getSecId());
            for(Curso c : cursos){
                cursos1.put(""+c.getCurId(), ""+c.getCurNombre());
                cc.add(new DefaultTreeNode(cursos1.get(""+c.getCurId()), ss.get(ss.size()-1)));
                //cc.add(new DefaultTreeNode(c.getCurNombre(), ss.get(ss.size()-1)));
            }
        }
        
        
    }  

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
    
    

    public Map<String, String> getSecciones1() {
        return secciones1;
    }

    public void setSecciones1(Map<String, String> secciones1) {
        this.secciones1 = secciones1;
    }

    public Map<String, String> getCursos1() {
        return cursos1;
    }

    public void setCursos1(Map<String, String> cursos1) {
        this.cursos1 = cursos1;
    }
    
    
  
    public TreeNode getRoot() {  
        return root;  
    }  
  
    public TreeNode getSelectedNode() {  
        return selectedNode;  
    }  
  
    public void setSelectedNode(TreeNode selectedNode) {  
        this.selectedNode = selectedNode;  
    }  

    public Map<String, String> getSecciones_rev() {
        return secciones_rev;
    }

    public void setSecciones_rev(Map<String, String> secciones_rev) {
        this.secciones_rev = secciones_rev;
    }

    public MateriaDataModel getMateriaDM() {
        return materiaDM;
    }

    public void setMateriaDM(MateriaDataModel materiaDM) {
        this.materiaDM = materiaDM;
    }
    
    
      
    public void displaySelectedSingle() {  
        if(selectedNode != null) {  
            System.out.println("entre al evento ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println("Valor del nodo: "+selectedNode.getData().toString());
            System.out.println("Valor del padre: "+secciones_rev.get(selectedNode.getParent().getData().toString()).toString());
            
            CursoLogic cl = new CursoLogic();
            Curso c = cl.buscarCursoSeccionParalelo(secciones_rev.get(selectedNode.getParent().getData().toString()).toString(), selectedNode.getData().toString(), "A");
            MateriaLogic ml = new MateriaLogic();
            ArrayList<Materia> lista = ml.buscarPorCurso(""+c.getCurId());
            for(Materia m : lista){
                System.out.println("materia: "+m.getMatId()+" / nombre: "+m.getMatNombre());
            }
            
            materiaDM = new MateriaDataModel(lista);  
        }  
    }
    

    public void agregarMateria(){
        CursoLogic cl = new CursoLogic();
        Curso c = cl.buscarCursoSeccionParalelo(secciones_rev.get(selectedNode.getParent().getData().toString()).toString(), selectedNode.getData().toString(), "A");
        Materia m = new Materia(0, parametro);
        MateriaDB mdb = new MateriaDB();
        mdb.agregarMateria(m);
        CursoMateriaDB cmdb = new CursoMateriaDB();
        cmdb.guardarSinProf(c, m);
        cmdb.llamarSP(""+c.getCurNombre(),""+c.getSeccion().getSecId());
    }
    
}  