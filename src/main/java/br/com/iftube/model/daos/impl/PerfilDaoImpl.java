package br.com.iftube.model.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.PerfilDAO;
import br.com.iftube.model.entities.Perfil;

@Repository
public class PerfilDaoImpl implements PerfilDAO{

	@PersistenceContext
	EntityManager em;

	public PerfilDaoImpl() {

	}

	@Transactional
	public Perfil adicionar(Perfil perfil) {
		em.persist(perfil);
		return perfil;
	}

	@Transactional
	public Perfil editar(Perfil perfil) {
		return em.merge(perfil);
	}

	@Transactional
	public void deletar(int perfilId) {
		em.remove(perfilId);
	}

	@Transactional
	public Perfil obterPerfilPorId(int perfilId) {
		return em.find(Perfil.class, perfilId);
	}

	@Transactional
	public Perfil obterPerfilPorNome(String nomePerfil) {
		try {
		Query q = em.createQuery("select c from Perfil c where c.nomePerfil=:nomePerfilParam");
		q.setParameter("nomePerfilParam", nomePerfil);
		q.setMaxResults(1);
		return (Perfil) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
			//throw new DAOException("Resgistro não encontrado", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Perfil> obterTodosPerfil() {
		Query q = em.createQuery("from Perfil");
		return q.getResultList();
	}

}
