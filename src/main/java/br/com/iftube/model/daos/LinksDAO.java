package br.com.iftube.model.daos;

import java.util.List;

import br.com.iftube.model.entities.Links;

public interface LinksDAO {

	public Links adicionar(Links link);
	public void editar(Links link);
	public void deletar(int linkId);
	public Links obterLinksPorId(int linkId);
	public Links obterLinkPorNome(String nomeLink);
	@SuppressWarnings("rawtypes")
	public List obterTodosLinks();
	@SuppressWarnings("rawtypes")
	public List obterTodosPalavrasChavesLinksIds();
}