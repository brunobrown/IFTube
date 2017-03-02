package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.daos.DisciplinaDAO;
import br.com.iftube.model.entities.Disciplina;
import br.com.iftube.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService, Converter<String, Disciplina>{

	@Autowired
	private DisciplinaDAO disciplinaDao;
	
	@Transactional
	public Disciplina adicionar(Disciplina disciplina) throws ServiceException{
		Disciplina disciplinaEncontrada = disciplinaDao.obterDisciplinaPorNome(disciplina.getNomeDisciplina());
		if(disciplinaEncontrada != null){
			throw new ServiceException("Disciplina já existe!");
		}
		
		return disciplinaDao.adicionar(disciplina);
	}
	
	@Transactional
	public void editar(Disciplina disciplina){
		disciplinaDao.editar(disciplina);
	}
	
	@Transactional
	public void deletar(int disciplinaId) {
		disciplinaDao.deletar(disciplinaId);
	}

	@Transactional
	public Disciplina obterDisciplinaPorId(int disciplinaId) {
		return disciplinaDao.obterDisciplinaPorId(disciplinaId);
	}
	
	@Transactional
	public Disciplina obterDisciplinaPorNome(String nomeDisciplina) {
		return disciplinaDao.obterDisciplinaPorNome(nomeDisciplina);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosDisciplina() {
		return disciplinaDao.obterTodosDisciplina();
	}
	
	@Transactional
	public Disciplina convert(String id) {
		
		if (!id.equals("")) {
			return disciplinaDao.obterDisciplinaPorId(Integer.valueOf(id));
		} else {
		    return null;
		}
	}

}
