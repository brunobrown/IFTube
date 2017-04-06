package br.com.iftube.service;

import java.util.List;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.Links;
import br.com.iftube.model.entities.Usuario;

public interface LinksService {

	public Links adicionar(Links link, Usuario usuario) throws ServiceException;
	public void editar(Links link);
	public void deletar(int linkId);
	public Links obterLinksPorId(int linkId);
	public Links obterLinkPorNome(String nomeLink);
	@SuppressWarnings("rawtypes")
	public List obterTodosLinks();
	
}
