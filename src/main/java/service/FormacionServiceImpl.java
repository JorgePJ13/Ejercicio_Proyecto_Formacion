package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import dao.CursosDao;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {

	AlumnosDao alumnosDao;

	CursosDao cursosDao;
	
	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, @Autowired CursosDao cursosDao) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
	}

	@Override
	public Alumno validarUsuario(String usuario, String password) {
		return alumnosDao.findByUsuarioAndPassword(usuario, password);
	}

	@Override
	public List<Curso> listaCursosAlumnoMatriculado(String usuario) {
		return cursosDao.findByAlumno(usuario);
	}

	@Override
	public List<Curso> listaCursos() {
		return cursosDao.findAll();
	}

	@Override
	public List<Alumno> listaAlumnos() {
		return alumnosDao.findAll();
	}
	
	@Override
	public List<Alumno> listaAlumnosMatriculadosCurso(String nombreCurso) {
		return alumnosDao.findByCurso(nombreCurso);
	}

	@Override
	public boolean matricularAlumno(String usuario, int idCurso) {
		Curso curso = cursosDao.findById(idCurso);
		Alumno alumno = alumnosDao.findById(usuario);
		if (curso != null && alumno != null) {
			alumno.getCursos().add(curso); // a los cursos del alumno se le añade el curso
			alumnosDao.update(alumno); // se actualiza el alumno
			return true;
		}
		return false;
	}

}
