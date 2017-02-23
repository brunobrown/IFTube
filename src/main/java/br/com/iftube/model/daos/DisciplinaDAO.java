package br.com.iftube.model.daos;

import java.util.List;

import br.com.iftube.model.entities.Disciplina;

public interface DisciplinaDAO {

	public Disciplina adicionar(Disciplina disciplina);
	public void editar(Disciplina disciplina);
	public void deletar(int disciplinaId);
	public Disciplina obterDisciplinaPorId(int disciplinaId);
	public Disciplina obterDisciplinaPorNome(String nomeDisciplina);
	@SuppressWarnings("rawtypes")
	public List obterTodosDisciplina();
}