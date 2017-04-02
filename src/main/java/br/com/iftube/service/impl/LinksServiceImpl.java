package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.LinksDAO;
import br.com.iftube.model.entities.Links;
import br.com.iftube.service.LinksService;

@Service
public class LinksServiceImpl implements LinksService {

	@Autowired
	private LinksDAO linksDao;
	
	
	@Transactional
	public Links adicionar(Links link) {
		return linksDao.adicionar(link);
	}

	@Transactional
	public void editar(Links link) {
		linksDao.editar(link);
	}

	@Transactional
	public void deletar(int linkId) {
		linksDao.deletar(linkId);
	}

	@Transactional
	public Links obterLinksPorId(int linkId) {
		return linksDao.obterLinksPorId(linkId);
	}

	@Transactional
	public Links obterLinkPorNome(String nomeLink) {
		return linksDao.obterLinkPorNome(nomeLink);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosLinks() {
		return linksDao.obterTodosLinks();
	}

}
