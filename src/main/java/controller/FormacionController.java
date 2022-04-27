package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController {

	@Autowired
	FormacionService service;
	
	@PostMapping("Login")
	public String loginAlumno(@ModelAttribute Alumno a) {
		Alumno alumno = service.validarUsuario(a.getUsuario(), a.getPassword());
		if(alumno != null) {
			return "menu";
		} else {
			return "error";
		}	
	}
	
	@GetMapping(value = "Alumnos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnos() {
		return service.listaAlumnos();
	}
	
	@GetMapping(value = "Cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursos() {
		return service.listaCursos();
	}
	
	@GetMapping(value = "AlumnosCurso", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnosCurso(@RequestParam("nombre") String nombreCurso) {
		return service.listaAlumnosMatriculadosCurso(nombreCurso);
	}
	
	@GetMapping(value = "CursosAlumno", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursosAlumno(@RequestParam("usuario") String usuario) {
		return service.listaCursosAlumnoMatriculado(usuario);
	}
}
