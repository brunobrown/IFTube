package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.UsuarioDAO;
import br.com.iftube.model.entities.Usuario;
import br.com.iftube.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService, Converter<String, Usuario>{

	@Autowired
	private UsuarioDAO usuarioDao;

	
	
	@Transactional
	public Usuario adicionar(Usuario usuario) {
		return usuarioDao.adicionar(usuario);
	}

	@Transactional
	public void editar(Usuario usuario) {
		usuarioDao.editar(usuario);
	}

	@Transactional
	public void deletar(int usuarioId) {
		usuarioDao.deletar(usuarioId);
	}

	@Transactional
	public Usuario obterUsuarioPorId(int usuarioId) {
		return usuarioDao.obterUsuarioPorId(usuarioId);
	}

	@Transactional
	public Usuario obterUsuarioPorNome(String nomeUsuario) {
		return usuarioDao.obterUsuarioPorNome(nomeUsuario);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosUsuario() {
		return usuarioDao.obterTodosUsuario();
	}
	
	@Transactional
	public Usuario convert(String id) {
		
		if (!id.equals("")) {
			return usuarioDao.obterUsuarioPorId(Integer.valueOf(id));
		} else {
		    return null;
		}
	}
	
}
