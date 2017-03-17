package br.com.iftube.service;

import java.util.List;

import br.com.iftube.model.entities.Usuario;

public interface UsuarioService {

	public Usuario adicionar(Usuario usuario);
	public void editar(Usuario usuario);
	public void deletar(int usuarioId);
	public Usuario obterUsuarioPorId(int usuarioId);
	public Usuario obterUsuarioPorNome(String nome);
	@SuppressWarnings("rawtypes")
	public List obterTodosUsuario();
	
}
