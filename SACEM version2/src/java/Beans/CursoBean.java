/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Curso;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import logica.CursoLogic;

/**
 *
 * @author Jorge Garcia
 */
@ManagedBean
@SessionScoped
public class CursoBean {

    private String query;
    private Curso selected;
    ArrayList<Curso> results;
    CursoLogic cl;
    
    public CursoBean() {
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Curso getSelected() {
        return selected;
    }

    public void setSelected(Curso selected) {
        this.selected = selected;
    }
    

    public CursoLogic getCl() {
        return cl;
    }

    public void setCl(CursoLogic cl) {
        this.cl = cl;
    }

    public ArrayList<Curso> getResults() {
        return results;
    }

    public void setResults(ArrayList<Curso> results) {
        this.results = results;
    }
    
    public void search(){
        cl = new CursoLogic();
        results = cl.buscarPorSeccion(query);
    }
    
}
