package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	/**
	 * Dado un usuario y contrase�a, se obtiene los datos del alumno
	 * @param usuario
	 * @param password
	 * @return Devuelve un usuario segun su usuario y contrase�a
	 */
	Alumno validarUsuario(String usuario, String password);
	
	/**
	 * Devuelve la lista de cursos en donde est� matriculado un alumno
	 * @param usuario
	 * @return los cursos en los que se matricul� el alumno
	 */
	List<Curso> listaCursosAlumnoMatriculado(String usuario);
	
	/**
	 * Devuelve la lista de cursos que hay en la BBDD
	 * @return la lista de cursos
	 */
	List<Curso> listaCursos();
	
	/**
	 * Devuelve la lista de cursos que hay en la BBDD
	 * @return la lista de cursos
	 */
	List<Alumno> listaAlumnos();
	
	/**
	 * Devuelve los alumnos que est�n matriculados en un curso
	 * @param nombreCurso
	 * @return la lista de alumnos matriculados en un determinado curso
	 */
	List<Alumno> listaAlumnosMatriculadosCurso(String nombreCurso);
	
	/**
	 * M�todo que matricula a un alumno en un curso
	 * @param usuario
	 * @param idCurso
	 * @return true si se ha matriculado con exito
	 */
	boolean matricularAlumno(String usuario, int idCurso);
	
	/**
	 * Metodo que busca un alumno segun su nombre de usuario
	 * @param usuario
	 * @return el alumno a buscar
	 */
	//Alumno buscarAlumno(String usuario);
	
	/**
	 * M�todo que busca un curso seg�n su identificador en la BBDD
	 * @param idCurso
	 * @return el curso a buscar
	 */
	//Curso buscarCurso(int idCurso);
	
}
