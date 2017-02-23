package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.DisciplinaDAO;
import br.com.iftube.model.entities.Disciplina;
import br.com.iftube.service.DisciplinaService;
import br.com.iftube.service.exception.ServiceException;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

	@Autowired
	private DisciplinaDAO disciplinaDao;
	
	
	@Transactional
	public Disciplina adicionar(Disciplina disciplina) throws ServiceException{
		Disciplina nomeDisciplina = disciplinaDao.obterDisciplinaPorNome(disciplina.getNomeDisciplina());
		if(nomeDisciplina != null){
			throw new ServiceException("Curso já cadastrado em disciplina Existente");
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

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosDisciplina() {
		return disciplinaDao.obterTodosDisciplina();
	}

}
