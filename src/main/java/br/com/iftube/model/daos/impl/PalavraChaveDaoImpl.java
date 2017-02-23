package br.com.iftube.model.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.PalavraChaveDAO;
import br.com.iftube.model.entities.PalavraChave;

@Repository
public class PalavraChaveDaoImpl implements PalavraChaveDAO {

	@PersistenceContext
	EntityManager em;

	public PalavraChaveDaoImpl() {

	}

	@Transactional
	public void adicionar(PalavraChave palavraChave) {
		em.persist(palavraChave);
	}

	@Transactional
	public void editar(PalavraChave palavraChave) {
		em.merge(palavraChave);
	}

	@Transactional
	public void deletar(int palavraChaveId) {
		em.remove(palavraChaveId);
	}

	@Transactional
	public PalavraChave obterPalavraChavePorId(int palavraChaveId) {
		return em.find(PalavraChave.class, palavraChaveId);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosPalavraChave() {
		Query q = em.createQuery("from PalavraChave");
		return q.getResultList();
	}

}
