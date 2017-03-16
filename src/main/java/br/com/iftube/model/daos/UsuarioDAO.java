package br.com.iftube.model.daos;

import java.util.List;

import br.com.iftube.model.entities.Usuario;

public interface UsuarioDAO {

	public Usuario adicionar(Usuario usuario);
	public Usuario editar(Usuario usuario);
	public void deletar(int usuarioId);
	public Usuario obterUsuarioPorId(int usuarioId);
	public Usuario obterUsuarioPorNome(String nomeUsuario);
	@SuppressWarnings("rawtypes")
	public List obterTodosUsuario();
}