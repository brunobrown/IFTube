package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.PerfilDAO;
import br.com.iftube.model.entities.Perfil;
import br.com.iftube.service.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService, Converter<String, Perfil>{

	@Autowired
	private PerfilDAO perfilDao;

	
	
	@Transactional
	public Perfil adicionar(Perfil perfil) {
		return perfilDao.adicionar(perfil);
	}

	@Transactional
	public void editar(Perfil perfil) {
		perfilDao.editar(perfil);
	}

	@Transactional
	public void deletar(int perfilId) {
		perfilDao.deletar(perfilId);
	}

	@Transactional
	public Perfil obterPerfilPorId(int perfilId) {
		return perfilDao.obterPerfilPorId(perfilId);
	}

	@Transactional
	public Perfil obterPerfilPorNome(String nomePerfil) {
		return perfilDao.obterPerfilPorNome(nomePerfil);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosPerfil() {
		return perfilDao.obterTodosPerfil();
	}
	
	@Transactional
	public Perfil convert(String id) {
		
		if (!id.equals("")) {
			return perfilDao.obterPerfilPorId(Integer.valueOf(id));
		} else {
		    return null;
		}
	}
	
}
