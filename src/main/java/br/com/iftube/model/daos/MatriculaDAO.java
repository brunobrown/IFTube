package br.com.iftube.model.daos;

import java.util.List;

import br.com.iftube.model.entities.Matricula;

public interface MatriculaDAO {

	public Matricula adicionar(Matricula matricula);
	public Matricula editar(Matricula matricula);
	public void deletar(Matricula matricula);
	public Matricula obterMatriculaPorId(int matriculaId);
	public Matricula obterMatriculaPorNome(String matricula);
	@SuppressWarnings("rawtypes")
	public List obterTodosMatricula();

	
}
