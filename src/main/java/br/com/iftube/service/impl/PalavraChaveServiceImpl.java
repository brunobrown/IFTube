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
public class PalavraChaveServiceImpl implements PalavraChaveService {

	@Autowired
	private PalavraChaveDAO palavraChaveDao;

	public PalavraChave adicionar(PalavraChave tag) throws ServiceException {
		// PalavraChave tagEncontrada = null;

		String[] tagSubDividida = tag.getTag().split("\r\n");

		/*
		 * for (String tagPesquisada : tagSubDividida) { tagEncontrada =
		 * palavraChaveDao.obterTagPorNome(tagPesquisada); if (tagEncontrada !=
		 * null) { throw new ServiceException("Tag (" + tagPesquisada +
		 * ") já existe!"); }
		 * 
		 * }
		 */

		for (String str : tagSubDividida) {
			PalavraChave palavraChave = new PalavraChave();
			palavraChave.setTag(str);
			palavraChave.setIdDisciplinaFk(tag.getIdDisciplinaFk());
			palavraChaveDao.adicionar(palavraChave);
		}

		return tag;
	}

	
	@Transactional
	public void editar(PalavraChave tag, String id) {
		String[] tagSubDividida = tag.getTag().split("\r\n");
		String[] idSubDivididoStr = id.split(",");
		int[] idSubDividido = new int[idSubDivididoStr.length];

		for (int i = 0; i < idSubDividido.length; i++) {
			idSubDividido[i] = Integer.parseInt(idSubDivididoStr[i]);
		}
		
		int i = 0;
		for (String str : tagSubDividida) {
			PalavraChave palavraChave = new PalavraChave();
			if (idSubDivididoStr.length - i > 0) {
				palavraChave.setId(idSubDividido[i]);
				palavraChave.setTag(str);
				palavraChave.setIdDisciplinaFk(tag.getIdDisciplinaFk());
				palavraChaveDao.editar(palavraChave);
				i++;
			} else if (idSubDivididoStr.length - i == 0) {
				palavraChave.setTag(str);
				palavraChave.setIdDisciplinaFk(tag.getIdDisciplinaFk());
				palavraChaveDao.adicionar(palavraChave);
			}
		}	
		
			int j = 0;
			int k = 0;
			int cont = 0;

			while (k < idSubDividido.length) {

				j = 0;
				cont = 0;

				while (j < tagSubDividida.length) {
					PalavraChave palavraChave = obterTagPorNome(tagSubDividida[j]);

					if (idSubDividido[k] != palavraChave.getId()) {
						j++;
						cont++;
					} else {
						break;
					}
				}

				if (cont == tagSubDividida.length) {
					PalavraChave p = new PalavraChave();
					p = palavraChaveDao.obterTagPorId(idSubDividido[k]);
					deletar(p);
					
				}
				k++;
			
		}
	}

	@Transactional
	public void deletar(PalavraChave tag) {
		palavraChaveDao.deletar(tag);
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
