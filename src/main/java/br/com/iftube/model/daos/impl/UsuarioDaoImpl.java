package br.com.iftube.model.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.UsuarioDAO;
import br.com.iftube.model.entities.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDAO{

	@PersistenceContext
	EntityManager em;

	public UsuarioDaoImpl() {

	}

	@Transactional
	public Usuario adicionar(Usuario usuario) {
		em.persist(usuario);
		return usuario;
	}

	@Transactional
	public Usuario editar(Usuario usuario) {
		return em.merge(usuario);
	}

	@Transactional
	public void deletar(int usuarioId) {
		em.remove(usuarioId);
	}

	@Transactional
	public Usuario obterUsuarioPorId(int usuarioId) {
		return em.find(Usuario.class, usuarioId);
	}

	@Transactional
	public Usuario obterUsuarioPorNome(String nomeUsuario) {
		try {
		Query q = em.createQuery("select c from Usuario c where c.nomeUsuario=:nomeUsuarioParam");
		q.setParameter("nomeUsuarioParam", nomeUsuario);
		q.setMaxResults(1);
		return (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
			//throw new DAOException("Resgistro não encontrado", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Usuario> obterTodosUsuario() {
		Query q = em.createQuery("from Usuario");
		return q.getResultList();
	}

}
