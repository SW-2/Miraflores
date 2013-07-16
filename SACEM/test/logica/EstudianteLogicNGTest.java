/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Estudiante;
import Clases.Persona;
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
public class EstudianteLogicNGTest {
    
    public EstudianteLogicNGTest() {
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
     * Test of obtenerUnico method, of class EstudianteLogic.
     */
    @Test
    public void testObtenerUnico() {
        System.out.println("obtenerUnico---------------------");
        String id = "30";
        EstudianteLogic instance = new EstudianteLogic();
        Estudiante expResult = new Estudiante();
        expResult.setPerId(30);
        Estudiante result = instance.obtenerUnico(id);
        assertEquals(result.getPersona().getPerApellidos(), "ANTEPARA DELGADO");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarEstudiante method, of class EstudianteLogic.
     */
//    @Test
    public void testGuardarEstudiante() {
        System.out.println("guardarEstudiante -------------------------");
        String direccion = "aaa bbb ccc";
        String cedula = "1234567890";
        String nombres = "Nombre de test";
        String apellidos = "apellido de test";
        String sexo = "M";
        String telefono = "234234";
        String celular = "2342347";
        String email = "email@hgh.com";
        String fecha = "2013-06-27";
        EstudianteLogic instance = new EstudianteLogic();
        boolean expResult = true;
        boolean result = instance.guardarEstudiante(direccion, cedula, nombres, apellidos, sexo, telefono, celular, email, fecha);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarEstudiante2 method, of class EstudianteLogic.
     */
  //  @Test
    public void testGuardarEstudiante2() {
        System.out.println("guardarEstudiante2 -------------------");
        Persona p = new Persona(90);
        EstudianteLogic instance = new EstudianteLogic();
        boolean expResult = true;
        boolean result = instance.guardarEstudiante2(p);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTodos method, of class EstudianteLogic.
     */
  //  @Test
    public void testObtenerTodos() {
        System.out.println("obtenerTodos -----------------------------");
        EstudianteLogic instance = new EstudianteLogic();
        ArrayList expResult = new ArrayList<Estudiante>(31);
        ArrayList result = instance.obtenerTodos();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}