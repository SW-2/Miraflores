/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Clases.CalificacionEstudiante;
import Clases.Curso;
import Clases.CursoEstudiante;
import Clases.CursoMateria;
import Clases.Estudiante;
import Clases.Materia;
import Clases.Persona;
import Clases.Profesor;
import Clases.Seccion;
import db.CursoMateriaDB;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import logica.CalificacionEstudianteLogic;
import logica.CursoEstudianteLogic;
import logica.CursoLogic;
import logica.CursoMateriaLogic;
import logica.MateriaLogic;
import logica.PersonaLogic;
import logica.ProfesorLogic;
import logica.SeccionLogic;


/**
 *
 * @author Jorge Garcia
 */
@ManagedBean
@ViewScoped
public class SeccionBean implements Serializable{
    private String seccionId;  
    private String cursoId;
    private String paraleloId;
    private String materiaId;
    
    private Persona selectedPersona;
    
    private Map<String,String> secciones = new HashMap<String, String>();  
    private Map<String,String> cursos = new HashMap<String, String>();
    private Map<String,String> paralelos = new HashMap<String, String>();
    private Map<String,String> materias = new HashMap<String, String>();
    
    private List<String> lista = new ArrayList<String>();
    private List<Estudiante> estudiantes = new ArrayList<Estudiante>();
    private List<CursoMateria> liCurMat = new ArrayList<CursoMateria>();
    
    private DataModel dmMaterias;
    private CursoMateria selectedCM;
    
    private Profesor selectedProfe = new Profesor();
    private ArrayList<Profesor> todosProfesores;
    
    PersonaDataModel results;
    CalificacionEstudianteDataModel calestDM;

    public SeccionBean() {
        SeccionLogic sl = new SeccionLogic();
        ArrayList<Seccion> lista = sl.obtenerTodas();
        for(Seccion s: lista){
            secciones.put(s.getSecNombre(),""+s.getSecId());
        }
    }

    public CursoMateria getSelectedCM() {
        return selectedCM;
    }

    public void setSelectedCM(CursoMateria selectedCM) {
        this.selectedCM = selectedCM;
    }

    public Profesor getSelectedProfe() {
        return selectedProfe;
    }

    public void setSelectedProfe(Profesor selectedProfe) {
        this.selectedProfe = selectedProfe;
    }

    public PersonaDataModel getResults() {
        return results;
    }

    public void setResults(PersonaDataModel results) {
        this.results = results;
    }

    public DataModel getDmMaterias() {
        return dmMaterias;
    }

    public void setDmMaterias(DataModel dmMaterias) {
        this.dmMaterias = dmMaterias;
    }

    
    public String getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(String seccionId) {
        this.seccionId = seccionId;
    }

    public String getParaleloId() {
        return paraleloId;
    }

    public void setParaleloId(String paraleloId) {
        this.paraleloId = paraleloId;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<CursoMateria> getLiCurMat() {
        return liCurMat;
    }

    public void setLiCurMat(List<CursoMateria> liCurMat) {
        this.liCurMat = liCurMat;
    }
    
    

    public Map<String, String> getParalelos() {
        return paralelos;
    }

    public void setParalelos(Map<String, String> paralelos) {
        this.paralelos = paralelos;
    }
    

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public Map<String, String> getSecciones() {
        return secciones;
    }

    public void setSecciones(Map<String, String> secciones) {
        this.secciones = secciones;
    }

    public Map<String, String> getCursos() {
        return cursos;
    }

    public void setCursos(Map<String, String> cursos) {
        this.cursos = cursos;
    }
    
    public void handleSeccionChange() {  
        if(seccionId != null && !seccionId.equals("")){
            liCurMat.clear();
            cursos = new HashMap<String, String>();  
            System.out.println("entre al evento ------------"+seccionId);
            CursoLogic cl = new CursoLogic();
            ArrayList<Curso> lista = cl.buscarPorSeccion(seccionId);
            for(Curso c: lista){
                cursos.put(""+c.getCurNombre(), ""+c.getCurId());
                System.out.println(c.getCurId()+"Curso ------->"+c.getCurNombre());
            }
        }
        else
            cursos = new HashMap<String, String>();  
        liCurMat.clear();
    }
    
    public void handleCursoChange(){
        if(cursoId != null && !cursoId.equals("")){
            liCurMat.clear();
            lista.clear();
            paralelos = new HashMap<String, String>();  
            
            CursoLogic cl = new CursoLogic();
            Curso c = cl.buscarUnico(cursoId);
            System.out.println("curso es    ---"+c.getCurNombre()+"  seccion es   ---"+seccionId);
            ArrayList<String> pars = cl.obtenerParalelos(seccionId, ""+c.getCurNombre());

            for(String s: pars){
                paralelos.put(s, s);
                lista.add(s);
            }
        }
        else{
            lista.clear();
            paralelos = new HashMap<String, String>();  
            liCurMat.clear();
        }
    }
    
    public void handeParaleloChange(){
        if(paraleloId!= null && !paraleloId.equals("")){
            materias = new HashMap<String, String>();  
            CursoLogic cl = new CursoLogic();
            System.out.append(seccionId+" - "+cursoId+" - "+paraleloId);
            Curso c1 = cl.buscarUnico(cursoId);
            Curso c = cl.buscarCursoSeccionParalelo(seccionId, ""+c1.getCurNombre(), paraleloId);
            MateriaLogic ml = new MateriaLogic();
            ArrayList<Materia> lista = ml.buscarPorCurso(""+c.getCurId());
            for(Materia m : lista){
                materias.put(m.getMatNombre(),""+m.getMatId());
            }
        }
        else
            materias = new HashMap<String, String>();  
    }
    
    public void handeParaleloChange2(){
        if(paraleloId!= null && !paraleloId.equals("")){
            estudiantes.clear();
            CursoLogic cl = new CursoLogic();
            System.out.append(seccionId+" - "+cursoId+" - "+paraleloId);
            Curso c1 = cl.buscarUnico(cursoId);
            Curso c = cl.buscarCursoSeccionParalelo(seccionId, ""+c1.getCurNombre(), paraleloId);
            CursoEstudianteLogic cel = new CursoEstudianteLogic();
            ArrayList<CursoEstudiante> ests = cel.buscarPorCurso(""+c.getCurId());
            
            for(CursoEstudiante ce: ests){
                Estudiante e = new Estudiante();
                e.setPerId(ce.getEstudiante().getPerId());
                estudiantes.add(e);
            }
            
            MateriaLogic ml = new MateriaLogic();
            ArrayList<Materia> lista = ml.buscarPorCurso(""+c.getCurId());
            for(Materia m : lista){
                materias.put(m.getMatNombre(),""+m.getMatId());
            }
        }
        else
            estudiantes.clear();
            
    }
    
    public void handeParaleloChange3(){
        if(paraleloId!= null && !paraleloId.equals("")){
            liCurMat.clear();
            ProfesorLogic pl = new ProfesorLogic();
            todosProfesores = pl.obtenerTodos();
            
            CursoMateriaLogic cml = new CursoMateriaLogic();
            
            CursoLogic cl = new CursoLogic();
            Curso c1 = cl.buscarUnico(cursoId);
            Curso c = cl.buscarCursoSeccionParalelo(seccionId, ""+c1.getCurNombre(), paraleloId);
            
            liCurMat = cml.materiasPorCursoParalelo(""+c.getCurId());
            dmMaterias = new ListDataModel(liCurMat);
            
        }
        else
            liCurMat.clear();
            
    }
    
    
    public void crearParalelo(){
        if(cursoId != null && !cursoId.equals("")){
            paralelos = new HashMap<String, String>();  
            CursoLogic cl = new CursoLogic();
            Curso c = cl.buscarUnico(cursoId);
            System.out.println("curso es    ---"+c.getCurNombre()+"  seccion es   ---"+seccionId);
            
            ArrayList<String> pars = cl.obtenerParalelos(seccionId, ""+c.getCurNombre());
            cl.crearParalelo(seccionId, ""+c.getCurNombre(), pars.get(pars.size()-1));
            pars = cl.obtenerParalelos(seccionId, ""+c.getCurNombre());
            lista = pars;
            CursoMateriaDB cmdb = new CursoMateriaDB();
            cmdb.llamarSP(""+c.getCurNombre(), seccionId);
        }
    }
    
    public void displayLocation(Persona per) {  
        FacesMessage msg = new FacesMessage("Selected", "Seccion:" + seccionId + ", Curso: " + cursoId);  
        System.out.println("La persona con cedula #"+per.getPerCedula()+" va al curso: "+cursoId+" de la seccion: "+seccionId);
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        CursoEstudianteLogic cel = new CursoEstudianteLogic();
        cel.guardar(""+per.getPerId(), cursoId);
    }  
    
    public void mostrarLista(){
        CursoLogic cl = new CursoLogic();
        
        Curso c1 = cl.buscarUnico(cursoId);
        Curso c = cl.buscarCursoSeccionParalelo(seccionId, ""+c1.getCurNombre(), paraleloId);

        String curso = ""+c.getCurId();
        System.out.println("Curso: "+curso+"---- Materia: "+materiaId);
        
        CursoMateriaLogic cml = new CursoMateriaLogic();
        CursoMateria cm = cml.buscarUnica(curso, materiaId);
        
        CalificacionEstudianteLogic cel = new CalificacionEstudianteLogic();
        ArrayList<CalificacionEstudiante> lista;
        lista = cel.obtenerPorCursoMateriaParcial(""+cm.getCurmatId(), "1");
        
        ArrayList<Persona> ests = new ArrayList<Persona>();
        PersonaLogic pl = new PersonaLogic();
        Persona p = new Persona();
        for(CalificacionEstudiante ce : lista){
            p = pl.buscarUnica(""+ce.getEstudiante().getPerId());
            ests.add(p);
        }
        
        calestDM = new CalificacionEstudianteDataModel(lista);
        
        results = new PersonaDataModel(ests);
    }

    public CalificacionEstudianteDataModel getCalestDM() {
        return calestDM;
    }

    public void setCalestDM(CalificacionEstudianteDataModel calestDM) {
        this.calestDM = calestDM;
    }
    
    

    public String getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(String materia) {
        this.materiaId = materia;
    }

    public Map<String, String> getMaterias() {
        return materias;
    }

    public void setMaterias(Map<String, String> materias) {
        this.materias = materias;
    }

    public Persona getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(Persona selectedPersona) {
        this.selectedPersona = selectedPersona;
    }
    
    public void enviarCalificaciones(){
        System.out.println("********////****Calificacion: --->");
        for(CalificacionEstudiante ce:calestDM ){
            System.out.println("********////****Calificacion: --->"+ce.getCalestNota());
        }
    }
    
    public List<String> autoComplete(String nombre){
        System.out.println("estoy aqui---------------------");
        System.out.println(nombre);
        List<String> ret = new ArrayList<String>();
        for(Profesor p: todosProfesores){
            if(p.getPersona().getPerApellidos().startsWith(nombre)){
                System.out.println(p.getPersona().getPerNombres());
                ret.add(p.getPerId()+" - "+p.getPersona().getPerApellidos().trim()+" "+p.getPersona().getPerNombres().trim());
            }
            if(p.getPersona().getPerNombres().startsWith(nombre)){
                ret.add(p.getPerId()+" - "+p.getPersona().getPerApellidos().trim()+" "+p.getPersona().getPerNombres().trim());
            }
        }
        return ret;
    }
    
    public void prueba(){
        System.out.println("-----------ya estamos aqui -->"+selectedProfe.getPerId());
    }
}

    