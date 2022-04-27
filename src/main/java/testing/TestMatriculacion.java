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
import service.FormacionService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ServiceConfig.class })
public class TestMatriculacion {

	@Autowired
	FormacionService service;
	
//	@Test
//	void testBuscarAlumno() {
//		assertNotNull(service.buscarAlumno("paco"));
//		assertNull(service.buscarAlumno("paco32"));
//	}

//	@Test
//	void testBuscarCurso() {
//		assertNotNull(service.buscarCurso(3));
//		assertNull(service.buscarCurso(20));
//	}
	
	@Test
	void testMatricularAlumno() {
		service.matricularAlumno("paco", 17);
		assertEquals(5, service.listaAlumnosMatriculadosCurso("kafka").size());
	}
}
