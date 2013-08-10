/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.Parentesco;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import logica.ParentescoLogic;

/**
 *
 * @author Jorge Garcia
 */
@ManagedBean
@ViewScoped
public class ParentescoBean {

    private String parentescoId;  
    
    private Map<String,String> parentescos = new HashMap<String, String>();  
    /**
     * Creates a new instance of ParentescoBean
     */
    public ParentescoBean() {
        ParentescoLogic pl = new ParentescoLogic();
        ArrayList<Parentesco> list = pl.obtenerTodas();
        for(Parentesco p: list){
            parentescos.put(p.getParentTipo(), ""+p.getParId());
        }
    }

    public String getParentescoId() {
        return parentescoId;
    }

    public void setParentescoId(String parentescoId) {
        this.parentescoId = parentescoId;
    }

    public Map<String, String> getParentescos() {
        return parentescos;
    }

    public void setParentescos(Map<String, String> parentescos) {
        this.parentescos = parentescos;
    }
    
}
