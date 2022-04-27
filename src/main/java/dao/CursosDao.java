package dao;

import java.util.List;

import model.Curso;

public interface CursosDao {

	/**
	 * Metodo que busca un curso por su identificador
	 * @param idCurso identificador del curso
	 * @return el curso según su id
	 */
	Curso findById(int idCurso);

	/**
	 * Metodo que busca todos los cursos
	 * @return una lista de todos los cursos
	 */
	List<Curso> findAll();

	/**
	 * Metodo que devuelve la lista de cursos en donde está matriculado un alumno
	 * @param usuario nombre del usuario a buscar en los cursos
	 * @return lista de cursos donde esta matriculado el alumno
	 */
	List<Curso> findByAlumno(String usuario);
}
