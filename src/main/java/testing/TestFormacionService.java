package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import model.Alumno;
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class })
public class TestFormacionService {

	@Autowired
	FormacionService service;	
	
	@Test
	void testValidarUsuario() {
		assertNotNull(service.validarUsuario("aaa", "sseeeee"));
	}
	
	@Test
	void testCursosAlumnoMatriculado() {
		assertEquals(2, service.listaCursosAlumnoMatriculado("aaa").size());
	}
	
	@Test
	void testListaCursos() {
		assertEquals(18, service.listaCursos().size());
	}
	
	@Test
	void testAlumnosMatriculadosCurso() {
		assertEquals(4, service.listaAlumnosMatriculadosCurso("python").size());
	}
	
}
