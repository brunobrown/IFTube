package br.com.iftube.model.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.MatriculaDAO;
import br.com.iftube.model.entities.Matricula;

@Repository
public class MatriculaDaoImpl implements MatriculaDAO{

	@PersistenceContext
	EntityManager em;

	public MatriculaDaoImpl() {

	}

	@Transactional
	public Matricula adicionar(Matricula matricula) {
		em.persist(matricula);
		return matricula;
	}

	@Transactional
	public Matricula editar(Matricula matricula) {
		return em.merge(matricula);
	}

	@Transactional
	public void deletar(Matricula matricula) {
		em.remove(matricula);
	}

	@Transactional
	public Matricula obterMatriculaPorId(String matricula) {
		return em.find(Matricula.class, matricula);
	}

	@Transactional
	public Matricula obterMatriculaPorNome(String matriculaAluno) {
		try {
		Query q = em.createQuery("select m from Matricula m where m.matriculaAluno=:matriculaAlunoParam");
		q.setParameter("matriculaAlunoParam", matriculaAluno);
		q.setMaxResults(1);
		return (Matricula) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
			//throw new DAOException("Resgistro não encontrado", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Matricula> obterTodosMatricula() {
		Query q = em.createQuery("from Matricula");
		return q.getResultList();
	}

}
