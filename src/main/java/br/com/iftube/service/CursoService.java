package br.com.iftube.service;

import java.util.List;

import br.com.iftube.model.entities.Curso;
import br.com.iftube.service.exception.ServiceException;

public interface CursoService {

	public Curso adicionar(Curso curso) throws ServiceException;
	public void editar(Curso curso);
	public void deletar(int cursoId);
	public Curso obterCursoPorId(int cursoId);
	@SuppressWarnings("rawtypes")
	public List obterTodosCurso();
	
}
