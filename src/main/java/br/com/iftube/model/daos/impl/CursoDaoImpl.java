package br.com.iftube.model.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.CursoDAO;
import br.com.iftube.model.entities.Curso;

@Repository
public class CursoDaoImpl implements CursoDAO{

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
	public Curso editar(Curso curso) {
		return em.merge(curso);
	}

	@Transactional
	public void deletar(Curso curso) {
		em.remove(curso);
	}

	@Transactional
	public Curso obterCursoPorId(int cursoId) {
		return em.find(Curso.class, cursoId);
	}

	@Transactional
	public Curso obterCursoPorNome(String nomeCurso) {
		try {
		Query q = em.createQuery("select c from Curso c where c.nomeCurso=:nomeCursoParam");
		q.setParameter("nomeCursoParam", nomeCurso);
		q.setMaxResults(1);
		return (Curso) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
			//throw new DAOException("Resgistro não encontrado", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Curso> obterTodosCurso() {
		Query q = em.createQuery("from Curso");
		return q.getResultList();
	}

}
