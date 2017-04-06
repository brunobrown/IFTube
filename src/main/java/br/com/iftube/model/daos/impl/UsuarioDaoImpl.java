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
public class UsuarioDaoImpl implements UsuarioDAO {

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
	public void editar(Usuario usuario) {
		em.merge(usuario);
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
	public Usuario obterUsuario(String login, String senha) {
		try {
				Query q = em.createQuery("select u from Usuario u where u.login=:loginParam and u.senha=:senhaParam");
				q.setParameter("loginParam", login);
				q.setParameter("senhaParam", senha);
				q.setMaxResults(1);
				return (Usuario) q.getSingleResult();
			} catch (NoResultException e) {
				return null;
				//throw new DAOException("Resgistro não encontrado", e);
			}
	}
			
	@Transactional
	public Usuario obterUsuarioPorNome(String nome) {
		try {
		Query q = em.createQuery("select u from Usuario u where u.nome=:nomeParam");
		q.setParameter("nomeParam", nome);
		q.setMaxResults(1);
		return (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
			//throw new DAOException("Resgistro não encontrado", e);
		}
	}
	
	@Transactional
	public Usuario obterUsuarioPorLogin(String login) {
		try {
		Query q = em.createQuery("select u from Usuario u where u.login=:loginParam");
		q.setParameter("loginParam", login);
		q.setMaxResults(1);
		return (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
			//throw new DAOException("Resgistro não encontrado", e);
		}
	}


	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosUsuario() {
		Query q = em.createQuery("from Usuario");
		return q.getResultList();
	}

}
