/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Administrador
 */
public class CalificacionEstudianteLogicNGTest {
    
    public CalificacionEstudianteLogicNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of obtenerPorCursoMateriaParcial method, of class CalificacionEstudianteLogic.
     */
    @Test
    public void testObtenerPorCursoMateriaParcial() {
        System.out.println("obtenerPorCursoMateriaParcial");
        String curmat = "";
        String parcial = "";
        CalificacionEstudianteLogic instance = new CalificacionEstudianteLogic();
        ArrayList expResult = null;
        ArrayList result = instance.obtenerPorCursoMateriaParcial(curmat, parcial);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}