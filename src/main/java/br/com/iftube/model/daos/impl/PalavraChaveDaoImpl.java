package br.com.iftube.model.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	public PalavraChave adicionar(PalavraChave tag) {
		
		em.persist(tag);
		//em.flush();
		return tag;
		
	}

	@Transactional
	public void editar(PalavraChave tag) {
		em.merge(tag);
	}

	@Transactional
	public void deletar(int tagId) {
		em.remove(tagId);
	}

	@Transactional
	public PalavraChave obterTagPorId(int tagId) {
		return em.find(PalavraChave.class, tagId);
	}
	
	@Transactional
	public PalavraChave obterTagPorNome(String tag) {
		try {
		Query q = em.createQuery("select d from PalavraChave d where d.tag=:tagParam");
		q.setParameter("tagParam", tag);
		q.setMaxResults(1);
		return (PalavraChave) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
			//throw new DAOException("Resgistro não encontrado", e);
		}
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosTag() {
		Query q = em.createQuery("from PalavraChave");
		return q.getResultList();
	}

}
