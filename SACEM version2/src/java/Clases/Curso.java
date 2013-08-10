package Clases;
// Generated 21-Jun-2013 10:00:31 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Curso generated by hbm2java
 */
public class Curso  implements java.io.Serializable {


     private int curId;
     private Seccion seccion;
     private String curCupo;
     private Integer curNombre;
     private Integer curAnioLectivo;
     private Character curParalelo;
     private String curEspecialidad;
     private Set<CursoMateria> cursoMaterias = new HashSet<CursoMateria>(0);
     private Set<CursoEstudiante> cursoEstudiantes = new HashSet<CursoEstudiante>(0);

    public Curso() {
    }

	
    public Curso(int curId) {
        this.curId = curId;
    }
    public Curso(int curId, Seccion seccion, String curCupo, Integer curNombre, Integer curAnioLectivo, Character curParalelo, String curEspecialidad, Set<CursoMateria> cursoMaterias, Set<CursoEstudiante> cursoEstudiantes) {
       this.curId = curId;
       this.seccion = seccion;
       this.curCupo = curCupo;
       this.curNombre = curNombre;
       this.curAnioLectivo = curAnioLectivo;
       this.curParalelo = curParalelo;
       this.curEspecialidad = curEspecialidad;
       this.cursoMaterias = cursoMaterias;
       this.cursoEstudiantes = cursoEstudiantes;
    }
   
    public int getCurId() {
        return this.curId;
    }
    
    public void setCurId(int curId) {
        this.curId = curId;
    }
    public Seccion getSeccion() {
        return this.seccion;
    }
    
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
    public String getCurCupo() {
        return this.curCupo;
    }
    
    public void setCurCupo(String curCupo) {
        this.curCupo = curCupo;
    }
    public Integer getCurNombre() {
        return this.curNombre;
    }
    
    public void setCurNombre(Integer curNombre) {
        this.curNombre = curNombre;
    }
    public Integer getCurAnioLectivo() {
        return this.curAnioLectivo;
    }
    
    public void setCurAnioLectivo(Integer curAnioLectivo) {
        this.curAnioLectivo = curAnioLectivo;
    }
    public Character getCurParalelo() {
        return this.curParalelo;
    }
    
    public void setCurParalelo(Character curParalelo) {
        this.curParalelo = curParalelo;
    }
    public String getCurEspecialidad() {
        return this.curEspecialidad;
    }
    
    public void setCurEspecialidad(String curEspecialidad) {
        this.curEspecialidad = curEspecialidad;
    }
    public Set<CursoMateria> getCursoMaterias() {
        return this.cursoMaterias;
    }
    
    public void setCursoMaterias(Set<CursoMateria> cursoMaterias) {
        this.cursoMaterias = cursoMaterias;
    }
    public Set<CursoEstudiante> getCursoEstudiantes() {
        return this.cursoEstudiantes;
    }
    
    public void setCursoEstudiantes(Set<CursoEstudiante> cursoEstudiantes) {
        this.cursoEstudiantes = cursoEstudiantes;
    }




}


