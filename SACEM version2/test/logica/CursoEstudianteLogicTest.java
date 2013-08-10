/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author PC
 */
public class CursoEstudianteLogicTest extends TestCase {
    
    public CursoEstudianteLogicTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of guardar method, of class CursoEstudianteLogic.
     */
    public void testGuardar() {
        System.out.println("guardar");
        String estId = "";
        String curId = "";
        CursoEstudianteLogic instance = new CursoEstudianteLogic();
        boolean expResult = false;
        boolean result = instance.guardar(estId, curId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorCurso method, of class CursoEstudianteLogic.
     */
    public void testBuscarPorCurso() {
        System.out.println("buscarPorCurso");
        String curso = "";
        CursoEstudianteLogic instance = new CursoEstudianteLogic();
        ArrayList expResult = null;
        ArrayList result = instance.buscarPorCurso(curso);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
