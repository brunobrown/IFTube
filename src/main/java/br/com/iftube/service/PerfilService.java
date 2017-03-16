package br.com.iftube.service;

import java.util.List;

import br.com.iftube.model.entities.Perfil;

public interface PerfilService {

	public Perfil adicionar(Perfil perfil);
	public void editar(Perfil perfil);
	public void deletar(int perfilId);
	public Perfil obterPerfilPorId(int perfilId);
	public Perfil obterPerfilPorNome(String nomePerfil);
	@SuppressWarnings("rawtypes")
	public List obterTodosPerfil();
	
}
