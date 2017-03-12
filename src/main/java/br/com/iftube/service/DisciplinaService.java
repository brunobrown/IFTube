package br.com.iftube.service;

import java.util.List;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.Disciplina;

public interface DisciplinaService {

	public Disciplina adicionar(Disciplina disciplina) throws ServiceException;
	public void editar(Disciplina disciplina) throws ServiceException;
	public void deletar(int disciplinaId);
	public Disciplina obterDisciplinaPorId(int disciplinaId);
	public Disciplina obterDisciplinaPorNome(String nomeDisciplina);
	public Disciplina alterarEstadoDisciplina(int id, String estadoDisciplina);
	public void alterarTodosEstadoDisciplina(int id, String estadoCurso) throws ServiceException;
	@SuppressWarnings("rawtypes")
	public List obterTodosDisciplina();
	
}
