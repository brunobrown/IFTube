package br.com.iftube.model.daos;

import java.util.List;

import br.com.iftube.model.entities.Usuario;

public interface UsuarioDAO {

	public Usuario adicionar(Usuario usuario);
	public void editar(Usuario usuario);
	public void deletar(int usuarioId);
	public Usuario obterUsuarioPorId(int usuarioId);
	public Usuario obterUsuario(String login, String senha);
	public Usuario obterUsuarioPorNome(String nome);
	public Usuario obterUsuarioPorLogin(String login);
	@SuppressWarnings("rawtypes")
	public List obterTodosUsuario();
}