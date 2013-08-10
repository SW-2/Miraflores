package Clases;
// Generated 21-Jun-2013 10:00:31 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Estado generated by hbm2java
 */
public class Estado  implements java.io.Serializable {


     private String estadoId;
     private String estadoDescripcion;
     private Set<Estudiante> estudiantes = new HashSet<Estudiante>(0);
     private Set<CursoEstudiante> cursoEstudiantes = new HashSet<CursoEstudiante>(0);
     private Set<Materia> materias = new HashSet<Materia>(0);
     private Set<Profesor> profesors = new HashSet<Profesor>(0);

    public Estado() {
    }

	
    public Estado(String estadoId) {
        this.estadoId = estadoId;
    }
    public Estado(String estadoId, String estadoDescripcion, Set<Estudiante> estudiantes, Set<CursoEstudiante> cursoEstudiantes, Set<Materia> materias, Set<Profesor> profesors) {
       this.estadoId = estadoId;
       this.estadoDescripcion = estadoDescripcion;
       this.estudiantes = estudiantes;
       this.cursoEstudiantes = cursoEstudiantes;
       this.materias = materias;
       this.profesors = profesors;
    }
   
    public String getEstadoId() {
        return this.estadoId;
    }
    
    public void setEstadoId(String estadoId) {
        this.estadoId = estadoId;
    }
    public String getEstadoDescripcion() {
        return this.estadoDescripcion;
    }
    
    public void setEstadoDescripcion(String estadoDescripcion) {
        this.estadoDescripcion = estadoDescripcion;
    }
    public Set<Estudiante> getEstudiantes() {
        return this.estudiantes;
    }
    
    public void setEstudiantes(Set<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    public Set<CursoEstudiante> getCursoEstudiantes() {
        return this.cursoEstudiantes;
    }
    
    public void setCursoEstudiantes(Set<CursoEstudiante> cursoEstudiantes) {
        this.cursoEstudiantes = cursoEstudiantes;
    }
    public Set<Materia> getMaterias() {
        return this.materias;
    }
    
    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }
    public Set<Profesor> getProfesors() {
        return this.profesors;
    }
    
    public void setProfesors(Set<Profesor> profesors) {
        this.profesors = profesors;
    }




}


