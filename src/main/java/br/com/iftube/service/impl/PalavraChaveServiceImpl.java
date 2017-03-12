package br.com.iftube.service.impl;

import java.util.HashSet;
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

		String[] tagSubDividida = tag.getTag().split("\r\n");
		HashSet<String> tags = new HashSet<String>();
		
		for (String t : tagSubDividida) {
			tags.add(new String(t));
		}

		for (String tagsStr : tags) {
			PalavraChave palavraChave = new PalavraChave();
			palavraChave.setTag(tagsStr);
			palavraChave.setIdDisciplinaFk(tag.getIdDisciplinaFk());
			palavraChaveDao.adicionar(palavraChave);
		}

		return tag;
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public void editar(PalavraChave tag, String id) {
		String[] tagSubDividida = tag.getTag().split("\r\n");
		HashSet<String> tags = new HashSet<String>();
		
		for (String t : tagSubDividida) {
			tags.add(new String(t));
		}
		
		List <PalavraChave> todasTags = obterTodosTag();
		
		if(id == null){
			id = "1";
		}
		String[] idSubDivididoStr = id.split(",");
		int[] idSubDividido = new int[idSubDivididoStr.length];

		for (int i = 0; i < idSubDividido.length; i++) {
			idSubDividido[i] = Integer.parseInt(idSubDivididoStr[i]);
		}
		
		int i = 0;
		int verificador = 0;
		for (String str : tags) {
			PalavraChave palavraChave = new PalavraChave();
			if (idSubDivididoStr.length - i > 0) {
				palavraChave.setId(idSubDividido[i]);
				palavraChave.setTag(str);
				palavraChave.setIdDisciplinaFk(tag.getIdDisciplinaFk());
				verificador = 0;
				for (PalavraChave t : todasTags) {
					if(t.getIdDisciplinaFk().getId() == tag.getIdDisciplinaFk().getId()){
						if(palavraChave.getTag().equals(t.getTag())){
							verificador++;
							break;
						}
					}
				}
				if(verificador == 0){
					palavraChaveDao.editar(palavraChave);
				}
				i++;
			} else if (idSubDivididoStr.length - i <= 0) {
				palavraChave.setTag(str);
				palavraChave.setIdDisciplinaFk(tag.getIdDisciplinaFk());
				verificador = 0;
				for (PalavraChave t : todasTags) {
					if(t.getIdDisciplinaFk().getId() == tag.getIdDisciplinaFk().getId()){
						if(palavraChave.getTag().equals(t.getTag())){
							verificador++;
							break;
						}
					}
				}
				
				if(verificador == 0){
					palavraChaveDao.adicionar(palavraChave);
				}
				
			}
			
		}
		
		if(idSubDividido.length > tagSubDividida.length){
			deletar(tagSubDividida, idSubDividido, tag.getIdDisciplinaFk().getId());
		}
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public void deletar(String[] tagSubDividida, int[] idSubDividido, int disciplinaId) {
		List <PalavraChave> todasTags = obterTodosTag();
		PalavraChave palavraChave = null;
		int j = 0;
		int k = 0;
		int cont = 0;

		while (k < idSubDividido.length) {

			j = 0;
			cont = 0;

			while (j < tagSubDividida.length) {
				
				for (PalavraChave t : todasTags) {
					if(t.getIdDisciplinaFk().getId() == disciplinaId && t.getTag().equals(tagSubDividida[j])){
						palavraChave = t;
						break;
					}
				}

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
				palavraChaveDao.deletar(p);
			}
			k++;
		
	}
		
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
