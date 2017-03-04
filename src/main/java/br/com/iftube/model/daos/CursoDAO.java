package br.com.iftube.model.daos;

import java.util.List;

import br.com.iftube.model.entities.Curso;

public interface CursoDAO {

	public Curso adicionar(Curso curso);
	public Curso editar(Curso curso);
	//public Curso desabilitarHabilitar(Curso curso);
	public void deletar(Curso curso);
	public Curso obterCursoPorId(int cursoId);
	public Curso obterCursoPorNome(String nomeCurso);
	@SuppressWarnings("rawtypes")
	public List obterTodosCurso();

	
}
