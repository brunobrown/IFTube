package br.com.iftube.service;

import java.util.List;

import br.com.iftube.model.entities.Disciplina;
import br.com.iftube.service.exception.ServiceException;

public interface DisciplinaService {

	public Disciplina adicionar(Disciplina disciplina) throws ServiceException;
	public void editar(Disciplina disciplina);
	public void deletar(int disciplinaId);
	public Disciplina obterDisciplinaPorId(int disciplinaId);
	@SuppressWarnings("rawtypes")
	public List obterTodosDisciplina();
	
}
