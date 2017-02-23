package br.com.iftube.model.daos;

import java.util.List;

import br.com.iftube.model.entities.Curso;

public interface CursoDAO {

	public Curso adicionar(Curso curso);
	public void editar(Curso curso);
	public void deletar(int cursoId);
	public Curso obterCursoPorId(int cursoId);
	@SuppressWarnings("rawtypes")
	public List obterTodosCurso();
	
}
