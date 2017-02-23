package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.PalavraChaveDAO;
import br.com.iftube.model.entities.PalavraChave;
import br.com.iftube.service.PalavraChaveService;

@Service
public class PalavraChaveServiceImpl implements PalavraChaveService {

	@Autowired
	private PalavraChaveDAO palavraChaveDao;
	
	
	@Transactional
	public void adicionar(PalavraChave palavraChave) {
		palavraChaveDao.adicionar(palavraChave);
	}

	@Transactional
	public void editar(PalavraChave palavraChave) {
		palavraChaveDao.editar(palavraChave);
	}

	@Transactional
	public void deletar(int palavraChaveId) {
		palavraChaveDao.deletar(palavraChaveId);
	}

	@Transactional
	public PalavraChave obterPalavraChavePorId(int palavraChaveId) {
		return palavraChaveDao.obterPalavraChavePorId(palavraChaveId);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosPalavraChave() {
		return palavraChaveDao.obterTodosPalavraChave();
	}

}
