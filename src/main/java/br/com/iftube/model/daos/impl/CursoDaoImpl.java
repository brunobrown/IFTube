package br.com.iftube.model.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.CursoDAO;
import br.com.iftube.model.entities.Curso;

@Repository
public class CursoDaoImpl implements CursoDAO {

	@PersistenceContext
	EntityManager em;

	public CursoDaoImpl() {

	}

	@Transactional
	public Curso adicionar(Curso curso) {
		em.persist(curso);
		return curso;
	}

	@Transactional
	public void editar(Curso curso) {
		em.merge(curso);
	}

	@Transactional
	public void deletar(int cursoId) {
		em.remove(cursoId);
	}

	@Transactional
	public Curso obterCursoPorId(int cursoId) {
		return em.find(Curso.class, cursoId);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Curso> obterTodosCurso() {
		Query q = em.createQuery("from Curso");
		return q.getResultList();
	}
	
}
