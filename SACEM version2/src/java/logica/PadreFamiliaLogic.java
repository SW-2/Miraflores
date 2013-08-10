/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Parentesco;
import Clases.Persona;
import db.PadreFamiliaDB;

/**
 *
 * @author Jorge Garcia
 */
public class PadreFamiliaLogic {
    PadreFamiliaDB pdb;

    public PadreFamiliaLogic() {
        pdb = new PadreFamiliaDB();
    }
    
    public boolean guardarRelacion(String padre, String hijo, String parent){
        PersonaLogic pl = new PersonaLogic();
        Persona pa = pl.buscarUnica(padre);
        Persona hi = pl.buscarUnica(hijo);
        
        ParentescoLogic parl = new ParentescoLogic();
        Parentesco rel = parl.obtenerUnica(parent);
        
        return pdb.guardarRelacion(pa, hi, rel, true);
    }
        
}
