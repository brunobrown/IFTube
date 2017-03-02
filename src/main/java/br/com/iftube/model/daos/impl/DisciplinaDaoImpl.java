package br.com.iftube.model.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.DisciplinaDAO;
import br.com.iftube.model.entities.Disciplina;

@Repository
public class DisciplinaDaoImpl implements DisciplinaDAO {

	@PersistenceContext
	EntityManager em;

	public DisciplinaDaoImpl() {

	}

	@Transactional
	public Disciplina adicionar(Disciplina disciplina) {
		em.persist(disciplina);
		return disciplina;
	}

	@Transactional
	public void editar(Disciplina disciplina) {
		em.merge(disciplina);
	}

	@Transactional
	public void deletar(int disciplinaId) {
		em.remove(disciplinaId);
	}

	@Transactional
	public Disciplina obterDisciplinaPorId(int disciplinaId) {
		return em.find(Disciplina.class, disciplinaId);
	}
	
	@Transactional
	public Disciplina obterDisciplinaPorNome(String nomeDisciplina) {
		try {
		Query q = em.createQuery("select d from Disciplina d where d.nomeDisciplina=:nomeDisciplinaParam");
		q.setParameter("nomeDisciplinaParam", nomeDisciplina);
		q.setMaxResults(1);
		return (Disciplina) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
			//throw new DAOException("Resgistro não encontrado", e);
		}
	}


	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosDisciplina() {
		Query q = em.createQuery("from Disciplina");
		return q.getResultList();
	}

}
