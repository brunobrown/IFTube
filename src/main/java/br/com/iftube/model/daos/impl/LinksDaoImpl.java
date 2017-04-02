package br.com.iftube.model.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.LinksDAO;
import br.com.iftube.model.entities.Links;

@Repository
public class LinksDaoImpl implements LinksDAO {

	@PersistenceContext
	EntityManager em;

	public LinksDaoImpl() {

	}

	@Transactional
	public Links adicionar(Links link) {
		em.persist(link);
		return link;
	}

	@Transactional
	public void editar(Links link) {
		em.merge(link);
	}

	@Transactional
	public void deletar(int linkId) {
		em.remove(linkId);
	}

	@Transactional
	public Links obterLinksPorId(int linkId) {
		return em.find(Links.class, linkId);
	}
	
	@Transactional
	public Links obterLinkPorNome(String nomeLinks) {
		try {
		Query q = em.createQuery("select d from Links d where d.nomeLinks=:nomeLinksParam");
		q.setParameter("nomeLinksParam", nomeLinks);
		q.setMaxResults(1);
		return (Links) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
			//throw new DAOException("Resgistro não encontrado", e);
		}
	}


	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosLinks() {
		Query q = em.createQuery("from Links");
		return q.getResultList();
	}

}
