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
	public Links obterLinkPorNome(String nomeLink) {
		try {
		Query q = em.createQuery("select l from Links l where l.link=:nomeLinkParam");
		q.setParameter("nomeLinkParam", nomeLink);
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

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosPalavrasChavesLinksIds() {
		Query q = em.createQuery("from Links as l left join fetch l.palavraChaveId");
		return q.getResultList();
	}
	
	//SELECT car FROM Carro as car JOIN FETCH car.acessorios WHERE car.codigo=?
	//from Links as l left join FETCH l.palavraChaveId as pc where pc.tag =: 2
	//SELECT l.id FROM Links l LEFT JOIN l.palavraChaveId p, WHERE p.idPerfil = :id
	
}
