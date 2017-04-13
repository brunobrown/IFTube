package br.com.iftube.model.daos;

import java.util.List;


import br.com.iftube.model.entities.PalavraChave;

public interface PalavraChaveDAO {

	public PalavraChave adicionar(PalavraChave tag);
	public void editar(PalavraChave tag);
	public void deletar(PalavraChave tag);
	public PalavraChave obterTagPorId(int tagId);
	public PalavraChave obterTagPorNome(String tag);
	@SuppressWarnings("rawtypes")
	public List obterTodosTag();
	@SuppressWarnings("rawtypes")
	public List obterTodosLinksPalavrasChavesIds();
	
}
