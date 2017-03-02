package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.daos.PalavraChaveDAO;
import br.com.iftube.model.entities.PalavraChave;
import br.com.iftube.service.PalavraChaveService;

@Service
public class PalavraChaveServiceImpl implements PalavraChaveService{

	@Autowired
	private PalavraChaveDAO palavraChaveDao;
	
	
	@Transactional
	public PalavraChave adicionar(PalavraChave tag) throws ServiceException {
		PalavraChave tagEncontrada = palavraChaveDao.obterTagPorNome(tag.getTag());
		if(tagEncontrada != null){
			throw new ServiceException("Disciplina já existe!");
		}
		
		return palavraChaveDao.adicionar(tag);
	}

	@Transactional
	public void editar(PalavraChave tag) {
		palavraChaveDao.editar(tag);
	}

	@Transactional
	public void deletar(int tagId) {
		palavraChaveDao.deletar(tagId);
	}

	@Transactional
	public PalavraChave obterTagPorId(int tagId) {
		return palavraChaveDao.obterTagPorId(tagId);
	}
	
	@Transactional
	public PalavraChave obterTagPorNome(String tag) {
		return palavraChaveDao.obterTagPorNome(tag);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosTag() {
		return palavraChaveDao.obterTodosTag();
	}

}
