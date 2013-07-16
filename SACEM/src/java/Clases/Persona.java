package Clases;
// Generated 21-Jun-2013 10:00:31 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private int perId;
     private String perDireccion;
     private String perNombres;
     private String perApellidos;
     private Date perFechaNacimiento;
     private Character perSexo;
     private String perTelefono;
     private String perCelular;
     private String perEmail;
     private String perCedula;
     private Set<Estudiante> estudiantes = new HashSet<Estudiante>(0);
     private Set<PadreFamilia> padreFamiliasForFamiliar = new HashSet<PadreFamilia>(0);
     private Set<PadreFamilia> padreFamiliasForEstudiante = new HashSet<PadreFamilia>(0);
     private Set<Profesor> profesors = new HashSet<Profesor>(0);

    public Persona() {
    }

    public Persona(int perId, String perDireccion, String perNombres, String perApellidos, Date perFechaNacimiento, Character perSexo, String perTelefono, String perCelular, String perEmail, String perCedula) {
        this.perId = perId;
        this.perDireccion = perDireccion;
        this.perNombres = perNombres;
        this.perApellidos = perApellidos;
        this.perFechaNacimiento = perFechaNacimiento;
        this.perSexo = perSexo;
        this.perTelefono = perTelefono;
        this.perCelular = perCelular;
        this.perEmail = perEmail;
        this.perCedula = perCedula;
    }
    
    

	
    public Persona(int perId) {
        this.perId = perId;
    }
    public Persona(int perId, String perDireccion, String perNombres, String perApellidos, Date perFechaNacimiento, Character perSexo, String perTelefono, String perCelular, String perEmail, String perCedula, Set<Estudiante> estudiantes, Set<PadreFamilia> padreFamiliasForFamiliar, Set<PadreFamilia> padreFamiliasForEstudiante, Set<Profesor> profesors) {
       this.perId = perId;
       this.perDireccion = perDireccion;
       this.perNombres = perNombres;
       this.perApellidos = perApellidos;
       this.perFechaNacimiento = perFechaNacimiento;
       this.perSexo = perSexo;
       this.perTelefono = perTelefono;
       this.perCelular = perCelular;
       this.perEmail = perEmail;
       this.perCedula = perCedula;
       this.estudiantes = estudiantes;
       this.padreFamiliasForFamiliar = padreFamiliasForFamiliar;
       this.padreFamiliasForEstudiante = padreFamiliasForEstudiante;
       this.profesors = profesors;
    }
   
    public int getPerId() {
        return this.perId;
    }
    
    public void setPerId(int perId) {
        this.perId = perId;
    }
    public String getPerDireccion() {
        return this.perDireccion;
    }
    
    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }
    public String getPerNombres() {
        return this.perNombres;
    }
    
    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }
    public String getPerApellidos() {
        return this.perApellidos;
    }
    
    public void setPerApellidos(String perApellidos) {
        this.perApellidos = perApellidos;
    }
    public Date getPerFechaNacimiento() {
        return this.perFechaNacimiento;
    }
    
    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }
    public Character getPerSexo() {
        return this.perSexo;
    }
    
    public void setPerSexo(Character perSexo) {
        this.perSexo = perSexo;
    }
    public String getPerTelefono() {
        return this.perTelefono;
    }
    
    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }
    public String getPerCelular() {
        return this.perCelular;
    }
    
    public void setPerCelular(String perCelular) {
        this.perCelular = perCelular;
    }
    public String getPerEmail() {
        return this.perEmail;
    }
    
    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }
    public String getPerCedula() {
        return this.perCedula;
    }
    
    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }
    public Set<Estudiante> getEstudiantes() {
        return this.estudiantes;
    }
    
    public void setEstudiantes(Set<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    public Set<PadreFamilia> getPadreFamiliasForFamiliar() {
        return this.padreFamiliasForFamiliar;
    }
    
    public void setPadreFamiliasForFamiliar(Set<PadreFamilia> padreFamiliasForFamiliar) {
        this.padreFamiliasForFamiliar = padreFamiliasForFamiliar;
    }
    public Set<PadreFamilia> getPadreFamiliasForEstudiante() {
        return this.padreFamiliasForEstudiante;
    }
    
    public void setPadreFamiliasForEstudiante(Set<PadreFamilia> padreFamiliasForEstudiante) {
        this.padreFamiliasForEstudiante = padreFamiliasForEstudiante;
    }
    public Set<Profesor> getProfesors() {
        return this.profesors;
    }
    
    public void setProfesors(Set<Profesor> profesors) {
        this.profesors = profesors;
    }




}

