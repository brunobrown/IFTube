package br.com.iftube.service;

import java.util.List;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.Matricula;

public interface MatriculaService {

	public Matricula adicionar(Matricula matricula) throws ServiceException;
	public Matricula editar(Matricula matricula) throws ServiceException;
	public void deletar(Matricula matricula);
	public boolean validarMatricula(String matriculaStr) throws ServiceException;
	public Matricula obterMatriculaPorId(int matriculaId);
	public Matricula obterMatriculaPorNome(String matricula);
	@SuppressWarnings("rawtypes")
	public List obterTodosMatricula();
	
}
