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
	
	@Transactional
	public Disciplina alterarEstadoDisciplina(int id, String estadoDisciplina) {
		Disciplina disciplina = obterDisciplinaPorId(id);
		disciplina.setEstadoDisciplina(estadoDisciplina);
		return disciplina;
	}
	
	@Transactional
	public void alterarTodosEstadoDisciplina(int id, String estadoCurso) {
		@SuppressWarnings("unchecked")
		List<Disciplina> estadoDisciplinaTodos = obterTodosDisciplina();
		
		for (Disciplina disc : estadoDisciplinaTodos) {
			
			if(estadoCurso.equals("ATIVO") && id == disc.getIdCursoFk().getId()){
				disc.setEstadoDisciplina("ATIVO");
				editar(disc);	
			}else if(estadoCurso.equals("INATIVO") && id == disc.getIdCursoFk().getId()){
				disc.setEstadoDisciplina("INATIVO");
				editar(disc);
			}
		}
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
