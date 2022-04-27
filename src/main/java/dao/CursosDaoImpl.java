package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Curso;

@Repository // igual que @Service, pero es para clases de acceso a datos
public class CursosDaoImpl implements CursosDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Curso findById(int idCurso) {
		return em.find(Curso.class, idCurso);
	}

	@Override
	public List<Curso> findAll() {
		String jpql = "select distinct(c) from Curso c";
		TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
		List<Curso> listaCursos = query.getResultList();
		return listaCursos.size() > 0 ? listaCursos : null;
	}

	@Override
	public List<Curso> findByAlumno(String usuario) {
		String jpql = "select distinct(c) from Curso c join c.alumnos a where a.usuario=?1";
		TypedQuery<Curso> query = em.createQuery(jpql, Curso.class);
		query.setParameter(1, usuario);
		List<Curso> listaCursos = query.getResultList();
		return listaCursos.size() > 0 ? listaCursos : null;
	}

}
