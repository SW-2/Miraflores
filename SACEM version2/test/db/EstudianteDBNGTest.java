/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import Clases.Estudiante;
import Clases.Persona;
import java.util.ArrayList;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author PC
 */
public class EstudianteDBNGTest {
    
    public EstudianteDBNGTest() {
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
     * Test of buscarTodo method, of class EstudianteDB.
     */
    @Test
    public void testBuscarTodo() {
        System.out.println("buscarTodo");
        EstudianteDB instance = new EstudianteDB();
        ArrayList expResult = null;
        ArrayList result = instance.buscarTodo();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarUnico method, of class EstudianteDB.
     */
    @Test
    public void testBuscarUnico() {
        System.out.println("buscarUnico");
        String id = "";
        EstudianteDB instance = new EstudianteDB();
        Estudiante expResult = null;
        Estudiante result = instance.buscarUnico(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarEstudiante method, of class EstudianteDB.
     */
    @Test
    public void testGuardarEstudiante() {
        System.out.println("guardarEstudiante");
        Persona p = null;
        Date ingreso = null;
        EstudianteDB instance = new EstudianteDB();
        boolean expResult = false;
        boolean result = instance.guardarEstudiante(p, ingreso);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}