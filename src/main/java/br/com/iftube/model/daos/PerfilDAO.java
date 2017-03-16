package br.com.iftube.model.daos;

import java.util.List;

import br.com.iftube.model.entities.Perfil;

public interface PerfilDAO {

	public Perfil adicionar(Perfil perfil);
	public Perfil editar(Perfil perfil);
	public void deletar(int perfilId);
	public Perfil obterPerfilPorId(int perfilId);
	public Perfil obterPerfilPorNome(String nomePerfil);
	@SuppressWarnings("rawtypes")
	public List obterTodosPerfil();
}