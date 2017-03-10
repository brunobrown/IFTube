package br.com.iftube.service;

import java.util.List;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.PalavraChave;

public interface PalavraChaveService {

	public PalavraChave adicionar(PalavraChave tag) throws ServiceException;
	public void editar(PalavraChave tag, String iDs);
	public void deletar(PalavraChave tag);
	public PalavraChave obterTagPorId(int tagId);
	public PalavraChave obterTagPorNome(String tag);
	@SuppressWarnings("rawtypes")
	public List obterTodosTag();
	
}
