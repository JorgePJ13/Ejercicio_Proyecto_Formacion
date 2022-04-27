package dao;

import java.util.List;

import model.Alumno;

public interface AlumnosDao {

	/**
	 * Metodo que devuelve un alumno según su usuario y contraseña
	 * @param usuario nombre del usuario
	 * @param password contraseña del usuario
	 * @return el alumno a buscar a partir de su usuario y contraseña
	 */
	Alumno findByUsuarioAndPassword(String usuario, String password);
	
	/**
	 * Metodo que devuelve los alumnos que están matriculados en un curso
	 * @param nombreCurso nombre del curso a buscar
	 * @return una lista de alumnos segun el nombre del curso
	 */
	List<Alumno> findByCurso(String nombreCurso);
	
	/**
	 * Metodo que devuelve el usuario segun su id
	 * @param usuario id (nombre) del usuario
	 * @return el usuario segun su id (nombre)
	 */
	Alumno findById(String usuario);
	
	/**
	 * Metodo que devuelve todos los alumnos
	 * @return la lista de alumnos
	 */
	List<Alumno> findAll();
	
	/**
	 * Metodo que actualiza la informacion del alumno
	 * @param a: el alumno
	 */ 
	void update(Alumno a);
}
