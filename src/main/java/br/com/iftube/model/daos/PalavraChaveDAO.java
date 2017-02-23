package br.com.iftube.model.daos;

import java.util.List;

import br.com.iftube.model.entities.PalavraChave;

public interface PalavraChaveDAO {

	public void adicionar(PalavraChave palavraChave);
	public void editar(PalavraChave palavraChave);
	public void deletar(int palavraChaveId);
	public PalavraChave obterPalavraChavePorId(int palavraChaveId);
	@SuppressWarnings("rawtypes")
	public List obterTodosPalavraChave();
	
}
