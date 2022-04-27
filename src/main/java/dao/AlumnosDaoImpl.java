package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Repository
public class AlumnosDaoImpl implements AlumnosDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Alumno findByUsuarioAndPassword(String usuario, String password) {
		String jpql = "select distinct(a) from Alumno a where a.usuario=?1 and a.password=?2";
		TypedQuery<Alumno> query = em.createQuery(jpql, Alumno.class);
		query.setParameter(1, usuario);
		query.setParameter(2, password);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Alumno> findByCurso(String nombreCurso) {
		String jpql = "select a from Alumno a join a.cursos c where c.nombre=?1";
		TypedQuery<Alumno> query = em.createQuery(jpql, Alumno.class);
		query.setParameter(1, nombreCurso);
		List<Alumno> listaAlumnos = query.getResultList();
		return listaAlumnos.size() > 0 ? listaAlumnos : null;
	}

	@Override
	public Alumno findById(String usuario) {
		return em.find(Alumno.class, usuario);
	}

	@Override
	public List<Alumno> findAll() {
		String jpql = "select distinct(a) from Alumno a";
		TypedQuery<Alumno> query = em.createQuery(jpql, Alumno.class);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size() > 0 ? alumnos : null;
	}

	@Transactional
	@Override
	public void update(Alumno a) {
		em.merge(a);

	}

}
