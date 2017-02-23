package br.com.iftube.service;

import java.util.List;

import br.com.iftube.model.entities.PalavraChave;

public interface PalavraChaveService {

	public void adicionar(PalavraChave palavraChave);
	public void editar(PalavraChave palavraChave);
	public void deletar(int palavraChaveId);
	public PalavraChave obterPalavraChavePorId(int palavraChaveId);
	@SuppressWarnings("rawtypes")
	public List obterTodosPalavraChave();
	
}
